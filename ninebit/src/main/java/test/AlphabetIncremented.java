package test;

public class AlphabetIncremented extends AlphabetIndexed
{

    AlphabetIncremented(Parameter p) //
    {
        super(p);
    }

    @Override
    public boolean next() {
        int i;
        int lower_one_count = 0;
        boolean found = false;
        for (i = 0; i < p.getCountCode() - 1; i++) // search bit to shift up
        {
            if (bitfield[i] && !bitfield[i + 1]) // found one to shift up
            {
                bitfield[i] = false;
                bitfield[i + 1] = true;
                found = true;
                break;
            } else if (bitfield[i]) // count ones to shift down
            {
                lower_one_count++;
            }
        }
        if (found) // dont at the end
        {
            for (int j = 0; j < i; j++) //
            {
                bitfield[j] = j < lower_one_count;
            }
            buildIndex();
        }
        return found;
    }
}
