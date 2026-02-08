package test;

//import static test.Parameter.*;

import java.security.SecureRandom;
import java.util.Random;

public class AlphabetRandomized extends AlphabetIndexed //
{
    AlphabetRandomized(Parameter p) //
    {
        super(p);
    }

    private int tryCount = 0;
    // Random r = new Random();
    Random r = new SecureRandom();

    @Override
    public boolean next() {
        int i, j;
        for (i = 0; i < p.getCountCode(); i++) // clear all
        {
            bitfield[i] = false;
        }
        for (i = p.getCountCode(); i > p.getCountCode() - p.getCountData(); i--) // randomize in
        {
            int insertIndex = r.nextInt(i);
            int lower_false_count = 0;
            for (j = 0; j < p.getCountCode(); j++) // 
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
        return tryCount++ < p.getCountRandomized();
    }
}
