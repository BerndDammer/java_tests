package test;


class NineBitNails //
{
    private NineBitNails(Parameter p) //
    {
        //AlphabetIndexed a = new AlphabetIncremented(p);
        AlphabetIndexed a = new AlphabetRandomized(p);
        do {
            AlphabetCollected ca = searchBitArr(p, a);
            if (ca.isInteresting()) //
            {
                System.out.println("CountFree: "+ ca.countFree());
                ResultPrinter.printResult(p, a, ca);
            }
        } while (a.next());
    }

    private AlphabetCollected searchBitArr(Parameter p, AlphabetIndexed a) //
    {
        AlphabetCollected ca = new AlphabetCollected(p);
        ca.collectIt(a);
        return ca;
    }

    public static void main(String[] args) //
    {
        new NineBitNails(new Parameter());
    }
}
