package test;

public class AlphabetCollected extends AlphabetIndexed//
{
    AlphabetCollected(Parameter p) //
    {
        super(p);
        for (int i = 0; i < p.getCountCode(); i++) {
            bitfield[i] = false;
        }
    }

    private void found(int index) {
        bitfield[index] = true;
    }

    public boolean isInteresting() {
        int c = 0;
        for (int i = 0; i < p.getCountCode(); i++) {
            if (!bitfield[i])
                c++;
        }
        return (c > p.getTrigger());
    }

    public boolean getAt(int i) //
    {
        return (bitfield[i]);
    }

    @Override
    public boolean next() // useless here
    {
        return false;
    }

    public void collectIt(AlphabetIndexed a) //
    {
        int i, j, k;
        for (i = 0; i < p.getCountData() - 1; i++) // check for every code
        {
            for (j = 0; j < p.getCountData(); j++) // with every code include self
            {
                int mask = a.get(i) | a.get(j) << p.getPow2Code();
                for (k = 0; k < p.getPow2Code(); k++) // every intersect bitmask
                {
                    int ind = (mask >> k) & (p.getCountCode() - 1);
                    found(ind);
                }
            }
        }
    }
}
