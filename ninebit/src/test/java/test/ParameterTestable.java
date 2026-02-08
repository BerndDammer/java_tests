package test;

public class ParameterTestable extends Parameter //
{
    public ParameterTestable(int p2data) //
    {
        pow2Data = p2data;
        pow2Code = p2data + 1;
        countData = 1 << pow2Data;
        countCode = 1 << pow2Code;

        trigger = 4711; // intentionally bullshit
        countRandomized = 1;
    }

    public ParameterTestable(int p2data, int trigger, int countRandomized) //
    {
        this(p2data);

        this.trigger = trigger;
        this.countRandomized = countRandomized;
    }
}
