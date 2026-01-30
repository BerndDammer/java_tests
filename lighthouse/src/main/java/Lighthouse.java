class Lighthouse //
{
    Lighthouse() //
    {
        boolean l1, l2, l3;

        for (int i = 0; i < 120; i++) //
        {
            boolean allOn, allOff;
            l1 = i % 6 < 3 ? true : false;
            l2 = i % 8 < 4 ? true : false;
            l3 = i % 10 < 5 ? true : false;
            allOn = l1 && l2 && l3;
            allOff = !l1 && !l2 && !l3;
            System.out.printf("%4d | %6B | %6B | %6B | %6B | %6B\n", i, l1, l2, l3, allOn, allOff);
        }
    }

    public static void main(String[] args) //
    {
        new Lighthouse();
    }
}