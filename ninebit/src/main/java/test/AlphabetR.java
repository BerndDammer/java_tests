package test;

import static test.Parameter.*;

import java.security.SecureRandom;
import java.util.Random;

public class AlphabetR extends Alphabet {
    private int tryCount = 0;
    // Random r = new Random();
    Random r = new SecureRandom();

    public boolean next() {
        int i, j;
        for (i = 0; i < countCode; i++) // search bit to shift up
        {
            bitfield[i] = false;
        }
        for (i = countCode; i > countCode - countData; i--) // search bit to shift up
        {
            int insertIndex = r.nextInt(i);
            int lower_false_count = 0;
            for (j = 0; j < countCode; j++) // search bit to shift up
            {
                if (!bitfield[j]) // found zero for possibile insert
                {
                    if (insertIndex == lower_false_count) // randomized insert
                    {
                        bitfield[j] = true;
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
