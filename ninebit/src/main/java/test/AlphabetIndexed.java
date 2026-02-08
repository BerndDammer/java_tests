package test;

public abstract class AlphabetIndexed //
{
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
            System.out.println("j " + j);
            throw new Error("invalid alphabet size");
        }
    }

    public abstract boolean next();
}
