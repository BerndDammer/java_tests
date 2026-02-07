package test;

public class Parameter //
{
    // TODO protected non final for testability ???
    protected int pow2Data = 3;
    protected int pow2Code = 4;
    protected int countData = 1 << pow2Data;
    protected int countCode = 1 << pow2Code;
    protected int trigger = 3;
    protected int countRandomized = 100 * 1000 * 1000;

    public int getPow2Data() {
        return pow2Data;
    }

    public int getPow2Code() {
        return pow2Code;
    }

    public int getCountData() {
        return countData;
    }

    public int getCountCode() {
        return countCode;
    }

    public int getTrigger() {
        return trigger;
    }

    public int getCountRandomized() {
        return countRandomized;
    }

    public Parameter() //
    {

    }
}
