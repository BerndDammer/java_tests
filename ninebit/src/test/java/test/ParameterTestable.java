package test;

public class ParameterTestable extends Parameter //
{
    // protected final int pow2Data = 3;
    // protected final int pow2Code = 4;
    // protected final int countData = 1 << pow2Data;
    // protected final int countCode = 1 << pow2Code;
    // protected final int trigger = 3;
    // protected final int countRandomized = 100 * 1000 * 1000;

    public ParameterTestable(int p2data) //
    {
        pow2Data = p2data;
        pow2Code = p2data + 1;
        countData = 1 << pow2Data;
        countCode = 1 << pow2Code;
        
        trigger = 4711; // intentionally bullshit
        countRandomized = 1;
    }
}
