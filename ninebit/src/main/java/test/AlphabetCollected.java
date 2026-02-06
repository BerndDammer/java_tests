package test;

//import static test.Parameter.trigger;

//import static test.Parameter.*;

public class AlphabetCollected extends AlphabetIndexed//
{

    AlphabetCollected(Parameter p) //
    {
        super(p);
        for (int i = 0; i < p.getCountCode(); i++) {
            bitfield[i] = false;
        }
    }

    void found(int index) {
        bitfield[index] = true;
    }

    // public void pNotFound() {
    //     int c = 0;
    //     for (int i = 0; i < p.getCountCode(); i++) {
    //         if (!bitfield[i])
    //             c++;
    //     }
    //     if (c > trigger)
    //         System.out.println("Number free bitmasks: " + c);
    // }

    public boolean isInteresting() {
        int c = 0;
        for (int i = 0; i < p.getCountCode(); i++) {
            if (!bitfield[i])
                c++;
        }
        return (c > p.getTrigger());
    }

    public boolean getAt(int i) //
    {
        return (bitfield[i]);
    }

    @Override
    public boolean next() // useless here
    {
        return false;
    }

}
