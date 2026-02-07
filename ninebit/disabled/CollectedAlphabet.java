package test;

import static test.Parameter.*;

public class CollectedAlphabet {
    boolean[] b = new boolean[countCode];

    CollectedAlphabet() {
        for (int i = 0; i < countCode; i++) {
            b[i] = false;
        }
    }

    void found(int index) {
        b[index] = true;
    }

    public void pNotFound() {
        int c = 0;
        for (int i = 0; i < countCode; i++) {
            if (!b[i])
                c++;
        }
        if (c > trigger)
            System.out.println("Number free bitmasks: " + c);
    }

    public boolean isInteresting() {
        int c = 0;
        for (int i = 0; i < countCode; i++) {
            if (!b[i])
                c++;
        }
        return (c > trigger);
    }

    public boolean get(int i) //
    {
        return (b[i]);
    }

}
