package test;

class AlphabetIndexedTestable extends AlphabetIndexed //
{
    AlphabetIndexedTestable(Parameter p, boolean[] bitfield) //
    {
        super(p);
        this.bitfield = bitfield;
        buildIndex();
    }

    @Override
    public boolean next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    public void buildIndex() // make it public
    {
        super.buildIndex();
    }

    public int[] getIndex() {
        return index;
    }
}