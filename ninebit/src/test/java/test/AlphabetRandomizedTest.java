package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

class AlphabetRandomizedTest //
{
    private static final Logger logger = Logger.getGlobal();

    class AlphabetRandomizedTestable extends AlphabetRandomized //
    {
        AlphabetRandomizedTestable(Parameter p) //
        {
            super(p);
        }

        public boolean[] getBitfield() {
            return bitfield;
        }
    }

    @Test
    void t1() //
    {
        Parameter p = new ParameterTestable(8, 20, 1000);
        int i, c;
        AlphabetRandomizedTestable art;

        art = new AlphabetRandomizedTestable(p);
        art.next();
        assertEquals(512, art.getBitfield().length, 512);
        c = 0;
        for (i = 0; i < art.getBitfield().length; i++) {
            if (art.getBitfield()[i]) {
                c++;
            }
        }
        assertEquals(256, c);
    }

    @Test
    void t2() //
    {
        final int COUNT = 1000;
        Parameter p = new ParameterTestable(8, 20, COUNT + 1);
        AlphabetRandomizedTestable art;
        double m;
        m = 0.0;
        art = new AlphabetRandomizedTestable(p);
        while (art.next()) {
            m += getMeanIndex(art, 256);
        }
        m /= (double) COUNT;
        logger.info("Rand t2 m : " + m);
        assertTrue(m > 254.6 && m < 257.0);
    }

    private double getMeanIndex(AlphabetRandomizedTestable art, int sizeIndex) //
    {
        double r = 0.0;
        int i;
        for (i = 0; i < sizeIndex; i++) {
            r += (double) art.get(i);
        }
        return (r / (double) sizeIndex);
    }
}

