package test;

import static test.Parameter.*;

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
        for (i = 0; i < countData - 1; i++) // check for every code
        {
            for (j = 0; j < countData; j++) // with every code include self
            {
                int mask = a.get(i) | a.get(j) << pow2Code;
                for (k = 0; k < pow2Code; k++) // every intersect bitmask
                {
                    int ind = (mask >> k) & (countCode - 1);
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
