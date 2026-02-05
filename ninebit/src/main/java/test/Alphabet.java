package test;

import static test.Parameter.*;

public class Alphabet //
{
    protected boolean[] bitfield = new boolean[countCode];
    protected int[] index = new int[countData];

    Alphabet() {
        for (int i = 0; i < countCode; i++) {
            bitfield[i] = i < countData;
        }
        buildIndex();
    }

    public int get(int i) {
        return index[i];
    }

    protected void buildIndex() {
        int j = 0;
        for (int i = 0; i < countCode; i++) {
            if (bitfield[i]) {
                index[j] = i;
                j++;
            }
        }
        if (j != countData)
            System.out.println("j " + j);
    }

    public boolean next() {
        int i;
        int lower_one_count = 0;
        boolean found = false;
        for (i = 0; i < countCode - 1; i++) // search bit to shift up
        {
            if (bitfield[i] && !bitfield[i + 1]) // found one to shift up
            {
                bitfield[i] = false;
                bitfield[i + 1] = true;
                found = true;
                break;
            } else if (bitfield[i]) // count ones to shift down
            {
                lower_one_count++;
            }
        }
        if (found) // dont at the end
        {
            for (int j = 0; j < i; j++) //
            {
                bitfield[j] = j < lower_one_count;
            }
            buildIndex();
        }
        return found;
    }
}
