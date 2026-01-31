class NineBit //

{
    private static final int POW2_DATA = 8;
    private static final int POW2_CODE = 9;
    private static final int COUNT_DATA = 256;
    private static final int COUNT_CODE = 512;

    private class Alphabet //
    {
        private boolean[] b = new boolean[512];
        private int[] index = new int[256];

        Alphabet() {
            for (int i = 0; i < 256; i++) {
                b[i] = true;
                b[i + 256] = false;
            }
            buildIndex();
        }

        public int get(int i) {
            return index[i];
        }

        private void buildIndex() {
            int j = 0;
            for (int i = 0; i < 512; i++) {
                if (b[i]) {
                    index[j] = i;
                    j++;
                }
            }
            if (j != 256)
                System.out.println("j " + j);
        }

        public boolean next() {
            int i;
            int lower_one_count = 0;
            boolean found = false;
            for (i = 0; i < 512 - 1; i++) // search bit to shift up
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

    private class CollectedAlphabet //
    {
        boolean[] b = new boolean[512];

        CollectedAlphabet() {
            for (int i = 0; i < 512; i++) {
                b[i] = false;
            }
        }

        void found(int index) {
            b[index] = true;
        }

        public void pNotFound() {
            int c = 0;
            for (int i = 0; i < 512; i++) {
                if (!b[i])
                    c++;
            }
            if (c > 3)
                System.out.println("Number free bitmasks: " + c);
        }
    }

    private NineBit() //
    {
        Alphabet a = new Alphabet();
        do {
            searchBitArr(a);
        } while (a.next());
    }

    private void searchBitArr(Alphabet a) //
    {
        CollectedAlphabet ca = new CollectedAlphabet();
        int i, j, k;
        for (i = 0; i < 256 - 1; i++) {
            for (j = i + 1; j < 256; j++) {
                int mask = a.get(i) | a.get(j) << 8;
                for (k = 0; k < 9; k++) {
                    int ind = (mask >> k) & (512 - 1);
                    ca.found(ind);
                }
            }
        }
        ca.pNotFound();
    }

    public static void main(String[] args) //
    {
        new NineBit();
    }
}