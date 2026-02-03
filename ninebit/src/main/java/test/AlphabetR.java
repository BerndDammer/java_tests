package test;

import static test.CONSTANTS.*;

import java.security.SecureRandom;
import java.util.Random;

public class AlphabetR extends Alphabet {
    private int tryCount = 0;
    // Random r = new Random();
    Random r = new SecureRandom();

    public boolean next() {
        int i, j;
        for (i = 0; i < COUNT_CODE; i++) // search bit to shift up
        {
            b[i] = false;
        }
        for (i = COUNT_CODE; i > COUNT_CODE - COUNT_DATA; i--) // search bit to shift up
        {
            int insertIndex = r.nextInt(i);
            int lower_false_count = 0;
            for (j = 0; j < COUNT_CODE; j++) // search bit to shift up
            {
                if (!b[j]) // found zero for possibile insert
                {
                    if (insertIndex == lower_false_count) // randomized insert
                    {
                        b[j] = true;
                        break;

                    } else //
                    {
                        lower_false_count++;
                    }
                }
            }
        }
        buildIndex();
        return tryCount++ < 100 * 1000 * 1000;
    }
}
