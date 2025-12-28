package bitbalance;

public class G4D3
{

    G4D3()
    {
        int l2, l1, l0;

        for (l2 = 1; l2 < 10; l2++)
        {
            for (l1 = 1; l1 < 10; l1++)
            {
                for (l0 = 1; l0 < 10; l0++)
                {
                    if (l2 + l1 + l0 == 15)
                    {
                        if( (l2 < l1) && (l1 < l0))
                        {
                            System.out.printf("\n%3d %3d %5d ", l2, l1, l0);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new G4D3();
    }
}

