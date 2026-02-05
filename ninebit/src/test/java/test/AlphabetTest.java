package test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Alphabet4Test //
{
    static Parameter c;

    @BeforeAll
    public static void initXXX() //
    {
        c = new Parameter();
    }

    @Test
    public void t1() //
    {
        assertTrue(3 == 3);
        assertEquals("XXX", "XXX");
    }
}
