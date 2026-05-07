#include "inc/tm4c1294ncpdt.h"

int wt = 0; // globale Variable für die Warteschleife

void sps_ports_init(void)
{
    // Clock Gating Control: Port K ist R9, Port L ist R10
    // Binär: 0110 0000 0000 (0x600)
    SYSCTL_RCGCGPIO_R |= 0x600; 
    
    // Kurze Warteschleife, bis die Clock stabil ist
    wt++;

    // Port K: SPS Eingänge (Pins 7, 5, 4, 3, 1, 0)
    // Digital-Funktion aktivieren (DEN)
    GPIO_PORTK_DEN_R |= 0xBD;  // 1011 1101 (Bits 7,5,4,3,1,0)
    // Datenrichtung: Eingänge (DIR-Bits auf 0)
    GPIO_PORTK_DIR_R &= ~0xBD; 

    // Port L: SPS Ausgänge (Pins 7, 6, 5, 4)
    // Digital-Funktion aktivieren (DEN)
    GPIO_PORTL_DEN_R |= 0xF0;  // 1111 0000 (Bits 7,6,5,4)
    // Datenrichtung: Ausgänge (DIR-Bits auf 1)
    GPIO_PORTL_DIR_R |= 0xF0;
}

void main(void) {
    // Variablen-Definition
    unsigned int inK, outL;
    int A, B, C, D, E, F;
    int sig_nand, sig_or2;

    // SPS Initialisierung
    sps_ports_init();

    while (1) {
        // --- SPS-Eingabe ---
        inK = GPIO_PORTK_DATA_R; // Einmaliges Einlesen
        
        // Maskierung der einzelnen Eingänge (Bit-Zuweisung laut Tabelle)
        D = (inK & (1 << 7)) ? 1 : 0;
        A = (inK & (1 << 5)) ? 1 : 0;
        C = (inK & (1 << 4)) ? 1 : 0;
        E = (inK & (1 << 3)) ? 1 : 0;
        B = (inK & (1 << 1)) ? 1 : 0;
        F = (inK & (1 << 0)) ? 1 : 0;

        // --- SPS-Verarbeitung ---
        // Logik für Output_1
        int out1 = C;

        // Logik für Output_2 (OR-Gatter)
        int out2 = D || A;

        // Logik für das NAND-Gatter (Eingänge: A, F und invertiertes E)
        // NAND(A, F, !E) = !(A && F && !E)
        sig_nand = !(A && F && !E);

        // Logik für Output_3 (XOR-Gatter: Output_2 XOR NAND-Signal)
        int out3 = out2 ^ sig_nand;

        // Logik für Output_4 (OR-Gatter: NAND-Signal OR Input_B)
        int out4 = sig_nand || B;

        // --- SPS-Ausgabe ---
        // Vorbereiten des Port L Registers (Read-Modify-Write)
        // Bestehende Bits sichern, Ziel-Bits (7-4) nullen
        outL = GPIO_PORTL_DATA_R & 0x0F; 

        // Neue Werte auf die Bits 7-4 schieben
        if(out3) outL |= (1 << 7);
        if(out1) outL |= (1 << 6);
        if(out2) outL |= (1 << 5);
        if(out4) outL |= (1 << 4);

        // Einmaliges Schreiben auf den Port
        GPIO_PORTL_DATA_R = outL;
    }
}