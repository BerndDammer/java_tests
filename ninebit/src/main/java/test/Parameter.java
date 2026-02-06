package test;

public class Parameter //
{
    private final int pow2Data = 3;
    private final int pow2Code = 4;
    private final int countData = 1 << pow2Data;
    private final int countCode = 1 << pow2Code;
    private final int trigger = 3;
    private final int countRandomized = 100 * 1000 * 1000;

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
