
public class Erastostenes //
{
    Erastostenes(int count)//
    {
        int[] f = new int[count];
        int i, j;
        for (i = 0; i < count; i++)//
        {
            f[i] = 0;
        }
        for (i = 2; i < count; i++)//
        {
            if (f[i] == 0)//
            {
                j = i;
                while (j < count) {
                    f[j]++;
                    j += i;
                }
            }
        }
        for (i = 0; i < count; i++)//
        {
            System.out.println("f[" + i + "] = " + f[i]);
        }
    }

    public static void main(String[] args)//
    {
        new Erastostenes(1000);
    }
}
