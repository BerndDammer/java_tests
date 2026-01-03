
package com.example;

import java.util.List;
import org.jnetpcap.*;

public class JPcapTest {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new JPcapTest();
    }

    JPcapTest() {
        init();
    }

    void init() {
        List<PcapIf> devices = Pcap.findAllDevs();
    }
}
