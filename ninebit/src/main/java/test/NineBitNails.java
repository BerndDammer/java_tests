package test;

import static test.CONSTANTS.*;

class NineBitNails //
{
    private NineBitNails() //
    {
        CollectedAlphabet ca;
        Alphabet a = new AlphabetR();
        do {
            ca= searchBitArr(a);
            if(ca.isInteresting())
            {
                ResultPrinter.printResult(a,ca);
            }
        } while (a.next());
    }

    private CollectedAlphabet searchBitArr(Alphabet a) //
    {
        CollectedAlphabet ca = new CollectedAlphabet();
        int i, j, k;
        for (i = 0; i < COUNT_DATA - 1; i++) {
            for (j = i + 1; j < COUNT_DATA; j++) {
                int mask = a.get(i) | a.get(j) << POW2_CODE;
                for (k = 0; k < POW2_CODE; k++) {
                    int ind = (mask >> k) & (COUNT_CODE - 1);
                    ca.found(ind);
                }
            }
        }
        ca.pNotFound();
        return ca;
    }

    public static void main(String[] args) //
    {
        new NineBitNails();
    }
}
