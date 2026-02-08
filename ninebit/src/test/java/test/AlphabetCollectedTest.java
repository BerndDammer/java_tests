package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AlphabetCollectedTest //
{
    class AlphabetCollectedTestable extends AlphabetCollected //
    {
        AlphabetCollectedTestable(Parameter p) //
        {
            super(p);
        }

        public boolean[] getBitfield() {
            return bitfield;
        }
    }

    private final boolean[][] t1bf1 = new boolean[][] // only all on off
    {
            { true, false, false, false, false, false, false, false, false, false, false, false, false, false, true },
            { true, true, false, true, false, false, false, true, true, false, false, false, true, false, true, true },
    };

    @Test
    public void t1() //
    {
        Parameter p = new ParameterTestable(3);
        AlphabetIndexedTestable ait;
        AlphabetCollectedTestable act;

        ait = new AlphabetIndexedTestable(p, t1bf1[0]);
        act = new AlphabetCollectedTestable(p);
        act.collectIt(ait);
        assertEquals(t1bf1[1], act.getBitfield());
    }

    private final boolean[][] t2bf1 = new boolean[][] // all single one
    {
            { false, true, true, false, true, false, false, false, true, false, false, false, false, false, false },
            { true, true, true, true, true, true, true, false, true, true, true, false, true, false, false, false },
    };

    private final boolean[][] t2bf2 = new boolean[][] //
    {
            { true, false, false, false, false, false, false, false, false, false, false, false, false, false, true },
            { true, true, false, true, false, false, false, true, true, false, false, false, true, false, true, true },
    };

    @Test
    public void t2() //
    {
        int i;
        boolean bf[][][] = //
                {
                        t2bf1,
                        t2bf2,
                };
        Parameter p = new ParameterTestable(3);
        AlphabetIndexedTestable ait;
        AlphabetCollectedTestable act;

        for (i = 0; i < bf.length; i++) {
            System.out.println("Coll t2 i: " + i);

            ait = new AlphabetIndexedTestable(p, bf[i][0]);
            act = new AlphabetCollectedTestable(p);
            act.collectIt(ait);
            assertEquals(bf[i][1], act.getBitfield());
        }
    }
}
