package test;

import static test.CONSTANTS.*;

public class Alphabet //
{
    protected boolean[] b = new boolean[COUNT_CODE];
    protected int[] index = new int[COUNT_DATA];

    Alphabet() {
        for (int i = 0; i < COUNT_CODE; i++) {
            b[i] = i < COUNT_DATA;
        }
        buildIndex();
    }

    public int get(int i) {
        return index[i];
    }

    protected void buildIndex() {
        int j = 0;
        for (int i = 0; i < COUNT_CODE; i++) {
            if (b[i]) {
                index[j] = i;
                j++;
            }
        }
        if (j != COUNT_DATA)
            System.out.println("j " + j);
    }

    public boolean next() {
        int i;
        int lower_one_count = 0;
        boolean found = false;
        for (i = 0; i < COUNT_CODE - 1; i++) // search bit to shift up
        {
            if (b[i] && !b[i + 1]) // found one to shift up
            {
                b[i] = false;
                b[i + 1] = true;
                found = true;
                break;
            } else if (b[i]) // count ones to shift down
            {
                lower_one_count++;
            }
        }
        if (found) // dont at the end
        {
            for (int j = 0; j < i; j++) //
            {
                b[j] = j < lower_one_count;
            }
            buildIndex();
        }
        return found;
    }
}
