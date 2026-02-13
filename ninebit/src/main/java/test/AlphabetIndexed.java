package test;

import java.util.logging.Logger;

public abstract class AlphabetIndexed //
{
    private static final Logger logger = Logger.getGlobal();

    protected final Parameter p;
    protected boolean[] bitfield;
    protected int[] index;

    AlphabetIndexed(Parameter p) //
    {
        this.p = p;
        bitfield = new boolean[p.getCountCode()];
        index = new int[p.getCountData()];

        for (int i = 0; i < p.getCountCode(); i++) // init first alphabet
        {
            bitfield[i] = i < p.getCountData();
        }
        buildIndex();
    }

    public int get(int i) {
        return index[i];
    }

    @SuppressWarnings("java:S112")
    protected void buildIndex() {
        int j = 0;
        for (int i = 0; i < p.getCountCode(); i++) {
            if (bitfield[i]) {
                index[j] = i;
                j++;
            }
        }
        if (j != p.getCountData()) //
        {
            String msg ="invalid alphabet size";
            logger.severe(msg);
            throw new Error(msg);
        }
    }

    public abstract boolean next();
}
