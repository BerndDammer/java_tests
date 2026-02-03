package test;

import static test.CONSTANTS.*;

public class CollectedAlphabet {
    boolean[] b = new boolean[COUNT_CODE];

    CollectedAlphabet() {
        for (int i = 0; i < COUNT_CODE; i++) {
            b[i] = false;
        }
    }

    void found(int index) {
        b[index] = true;
    }

    public void pNotFound() {
        int c = 0;
        for (int i = 0; i < COUNT_CODE; i++) {
            if (!b[i])
                c++;
        }
        if (c > TRIGGER)
            System.out.println("Number free bitmasks: " + c);
    }

    public boolean isInteresting() {
        int c = 0;
        for (int i = 0; i < COUNT_CODE; i++) {
            if (!b[i])
                c++;
        }
        return (c > TRIGGER);
    }

    public boolean get(int i) //
    {
        return (b[i]);
    }

}
