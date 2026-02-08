package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AlphabetIncrementedTest //
{
    static Parameter para3;
    static Parameter para2;
    static Parameter para1;

    @BeforeAll
    public static void initXXX() //
    {
        para3 = new ParameterTestable(3);
        para2 = new ParameterTestable(2);
        para1 = new ParameterTestable(1);
    }

    class AlphabetIncrementedTestable extends AlphabetIncremented //
    {
        AlphabetIncrementedTestable(Parameter p, boolean[] bitfield) //
        {
            super(p);
            this.bitfield = bitfield;
        }

        public boolean[] getBitfield() {
            return bitfield;
        }
    }

    @Test
    public void t1() //
    {
        boolean[] bf1 = new boolean[] //
        { //
                true, false, false, true, //
                false, true, false, true, //
                true, false, true, false, //
                false, false, true, true //
        };
        boolean[] ba1 = new boolean[] //
        { //
                false, true, false, true, //
                false, true, false, true, //
                true, false, true, false, //
                false, false, true, true //
        };
        testStepping(para3, bf1, ba1, true);
    }

    @Test
    @Disabled
    public void t2() //
    {
        int i;
        boolean r;
        boolean[][] bf = new boolean[][] //
        {
                { true, true, true, true, false, false, false, false },
                { true, true, true, false, true, false, false, false },
                { true, true, false, true, true, false, false, false },
                { true, false, true, true, true, false, false, false },
                { false, true, true, true, true, false, false, false },
                { false, true, true, true, false, true, false, false },
                { false, true, true, false, true, true, false, false },
        };
        AlphabetIncrementedTestable ait = new AlphabetIncrementedTestable(para2, bf[0]);
        for (i = 1; i < bf.length; i++) //
        {
            System.out.println("t2 " + i);
            r = ait.next();
            // assertEquals(i != bf.length - 1, r);
            assertEquals(true, r);
            assertArrayEquals(bf[i], ait.getBitfield());
        }
    }

    @Test
    public void t3() //
    {
        int i;
        boolean r;
        boolean[][] bf = new boolean[][] //
        {
                { true, true, false, false },
                { true, false, true, false },
                { false, true, true, false },
                { true, false, false, true },
                { false, true, false, true },
                { false, false, true, true },
                { false, false, true, true }, // last next AFTER highest gives false
        };
        AlphabetIncrementedTestable ait = new AlphabetIncrementedTestable(para1, bf[0]);
        for (i = 1; i < bf.length; i++) //
        {
            System.out.println("t3 " + i);
            r = ait.next();
            assertEquals(i != bf.length - 1, r);
            assertArrayEquals(bf[i], ait.getBitfield());
        }
    }

    private final boolean[][] t4bf1 = new boolean[][] //
    {
            { true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false },
            { true, true, true, true, true, true, true, false, true, false, false, false, false, false, false, false },
    };

    private final boolean[][] t4bf2 = new boolean[][] //
    {
            { false, false, false, false, false, false, false, true, false, true, true, true, true, true, true, true },
            { false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true },
    };

    private final boolean[][] t4bflast = new boolean[][] //
    {
            { false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true },
            { false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true },
    };

    @Test
    public void t4() //
    {
        Parameter p = new ParameterTestable(3);
        int i;
        boolean r;
        boolean[][][] bf = new boolean[][][] //
        {
                t4bf1,
                t4bf2,
        };
        AlphabetIncrementedTestable ait;

        for (i = 1; i < bf.length; i++) //
        {
            System.out.println("t4 " + i);
            ait = new AlphabetIncrementedTestable(p, bf[i][0]);
            r = ait.next();
            assertEquals(true, r);
            assertArrayEquals(bf[i][1], ait.getBitfield());
        }

        // last
        ait = new AlphabetIncrementedTestable(p, t4bflast[0]);
        r = ait.next();
        assertEquals(false, ait.next());
        assertArrayEquals(t4bflast[1], ait.getBitfield());
    }

    public void testStepping(Parameter p, boolean[] before, boolean[] after, boolean hasNext) //
    {
        AlphabetIncrementedTestable ait = new AlphabetIncrementedTestable(p, before);
        assertEquals(hasNext, ait.next());
        assertArrayEquals(after, ait.getBitfield());
    }
}
