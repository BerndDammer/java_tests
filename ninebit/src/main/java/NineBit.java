class NineBit //

{
    private static final int POW2_DATA = 4;
    private static final int POW2_CODE = 5;
    private static final int COUNT_DATA = 1 << POW2_DATA;
    private static final int COUNT_CODE = 1 << POW2_CODE;
    private static final int TRIGGER = 10;

    private class Alphabet //
    {
        private boolean[] b = new boolean[COUNT_CODE];
        private int[] index = new int[COUNT_DATA];

        Alphabet() {
            for (int i = 0; i < COUNT_CODE; i++) {
                b[i] = i < COUNT_DATA;
            }
            buildIndex();
        }

        public int get(int i) {
            return index[i];
        }

        private void buildIndex() {
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
        new NineBit();
    }
}