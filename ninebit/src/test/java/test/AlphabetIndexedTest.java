package test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetIndexedTest //
{
    static Parameter para3;

    @BeforeAll
    static void initXXX() //
    {
        para3 = new ParameterTestable(3);
    }

    @Test
    void t1() //
    {
        boolean[] bf = new boolean[] //
        { //
                true, false, false, true, //
                false, true, false, true, //
                true, false, true, false, //
                false, false, true, true //
        };
        int[] iex = new int[] //
        {
                0, 3, 5, 7, 8, 10, 14, 15
        };
        AlphabetIndexedTestable ait = new AlphabetIndexedTestable(para3, bf);
        ait.buildIndex();
        assertArrayEquals(iex, ait.index, "t1-indexed");
    }
}
