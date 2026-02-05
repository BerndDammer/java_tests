package test;

import static test.CONSTANTS.*;

class NineBitNails //
{
    private NineBitNails() //
    {
        Alphabet a = new Alphabet();
        do {
            CollectedAlphabet ca = searchBitArr(a);
            if (ca.isInteresting()) //
            {
                ResultPrinter.printResult(a, ca);
            }
        } while (a.next());
    }

    private CollectedAlphabet searchBitArr(Alphabet a) //
    {
        CollectedAlphabet ca = new CollectedAlphabet();
        int i, j, k;
        for (i = 0; i < COUNT_DATA - 1; i++) // check for every code
        {
            for (j = 0; j < COUNT_DATA; j++) // with every code include self
            {
                int mask = a.get(i) | a.get(j) << POW2_CODE;
                for (k = 0; k < POW2_CODE; k++) // every intersect bitmask
                {
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
