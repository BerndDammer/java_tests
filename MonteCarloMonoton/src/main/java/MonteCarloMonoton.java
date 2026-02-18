
import java.util.Random;

public class MonteCarloMonoton //
{
    @FunctionalInterface
    public interface Func //
    {
        double func(double d);
    }

    private final Func func;

    MonteCarloMonoton(Func func, double start, double end, int shotCount)//
    {
        this.func = func;
        int countIn = 0;
        Random r = new Random();
        double y1 = func.func(end);
        double y2 = func.func(start);
        double yo = Math.max(y1, y2);
        for (int i = 0; i < shotCount; i++) //
        {
            double xp = r.nextDouble(start, end);
            double yp = r.nextDouble(0.0, yo);
            double y = func.func(xp);

            if (yp < y) //
            {
                countIn++;
            }
        }
        double ag = (end - start) * yo;
        double integral = ag * (double) countIn / (double) shotCount;
        System.out.println("Integral : " + integral);
    }

    public static double f1(double d) //
    {
        return (Math.exp(d * d));
    }

    public static double f2(double d) //
    {
        return (Math.exp(-d * d));
    }

    public static void main(String[] args)//
    {
        new MonteCarloMonoton(MonteCarloMonoton::f1, 2.0, 5.0, 1000 * 1000);
        new MonteCarloMonoton(MonteCarloMonoton::f2, 2.0, 5.0, 1000 * 1000);
    }
}
