import java.security.SecureRandom;
import java.util.Random;

class NineBitNails //
{
    private static final int POW2_DATA = 4;
    private static final int POW2_CODE = 5;
    private static final int COUNT_DATA = 1 << POW2_DATA;
    private static final int COUNT_CODE = 1 << POW2_CODE;
    private static final int TRIGGER = 10;

    private class Alphabet //
    {
        protected boolean[] b = new boolean[COUNT_CODE];
        protected int[] index = new int[COUNT_DATA];

        Alphabet() {
            for (int i = 0; i < COUNT_CODE; i++) {
                b[i] = i < COUNT_DATA;
            }
            buildIndex();
        }

        public int get(int i) {
            return index[i];
        }

        protected void buildIndex() {
            int j = 0;
            for (int i = 0; i < COUNT_CODE; i++) {
                if (b[i]) {
                    index[j] = i;
                    j++;
                }
            }
            if (j != COUNT_DATA)
                System.out.println("j " + j);
        }

        public boolean next() {
            int i;
            int lower_one_count = 0;
            boolean found = false;
            for (i = 0; i < COUNT_CODE - 1; i++) // search bit to shift up
            {
                if (b[i] && !b[i + 1]) // found one to shift up
                {
                    b[i] = false;
                    b[i + 1] = true;
                    found = true;
                    break;
                } else if (b[i]) // count ones to shift down
                {
                    lower_one_count++;
                }
            }
            if (found) // dont at the end
            {
                for (int j = 0; j < i; j++) //
                {
                    b[j] = j < lower_one_count;
                }
                buildIndex();
            }
            return found;
        }
    }

    private class AlphabetR extends Alphabet {
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
            return tryCount++ < 1 * 1000 * 1000;
        }
    }

    private class CollectedAlphabet //
    {
        boolean[] b = new boolean[COUNT_CODE];

        CollectedAlphabet() {
            for (int i = 0; i < COUNT_CODE; i++) {
                b[i] = false;
            }
        }

        void found(int index) {
            b[index] = true;
        }

        public void pNotFound() {
            int c = 0;
            for (int i = 0; i < COUNT_CODE; i++) {
                if (!b[i])
                    c++;
            }
            if (c > TRIGGER)
                System.out.println("Number free bitmasks: " + c);
        }
    }

    private NineBitNails() //
    {
        Alphabet a = new AlphabetR();
        do {
            searchBitArr(a);
        } while (a.next());
    }

    private void searchBitArr(Alphabet a) //
    {
        CollectedAlphabet ca = new CollectedAlphabet();
        int i, j, k;
        for (i = 0; i < COUNT_DATA - 1; i++) {
            for (j = i + 1; j < COUNT_DATA; j++) {
                int mask = a.get(i) | a.get(j) << POW2_CODE;
                for (k = 0; k < POW2_CODE; k++) {
                    int ind = (mask >> k) & (COUNT_CODE - 1);
                    ca.found(ind);
                }
            }
        }
        ca.pNotFound();
    }

    public static void main(String[] args) //
    {
        new NineBitNails();
    }
}
