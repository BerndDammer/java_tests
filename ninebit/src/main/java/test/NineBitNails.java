package test;

//import static test.Parameter.*;

class NineBitNails //
{
    private NineBitNails(Parameter p) //
    {
        AlphabetIndexed a = new AlphabetIncremented(p);
        do {
            AlphabetCollected ca = searchBitArr(p,a);
            if (ca.isInteresting()) //
            {
                ResultPrinter.printResult(p, a, ca);
            }
        } while (a.next());
    }

    private AlphabetCollected searchBitArr(Parameter p, AlphabetIndexed a) //
    {
        AlphabetCollected ca = new AlphabetCollected(p);
        int i, j, k;
        for (i = 0; i < p.getCountData() - 1; i++) // check for every code
        {
            for (j = 0; j < p.getCountData(); j++) // with every code include self
            {
                int mask = a.get(i) | a.get(j) << p.getPow2Code();
                for (k = 0; k < p.getPow2Code(); k++) // every intersect bitmask
                {
                    int ind = (mask >> k) & (p.getCountCode() - 1);
                    ca.found(ind);
                }
            }
        }
        //ca.pNotFound();
        return ca;
    }

    public static void main(String[] args) //
    {
        new NineBitNails(new Parameter());
    }
}
