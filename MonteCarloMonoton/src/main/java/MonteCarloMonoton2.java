
import java.util.Random;
import java.util.function.DoubleFunction;

public class MonteCarloMonoton2 //
{
    MonteCarloMonoton2(DoubleFunction<Double> func,
            double start, double end, int shotCount) //
    {
        int countIn = 0;
        Random r = new Random();
        double yend = func.apply(end);
        double ystart = func.apply(start);
        double yo = Math.max(yend, ystart);

        for (int i = 0; i < shotCount; i++) //
        {
            double xp = r.nextDouble(start, end);
            double yp = r.nextDouble(0.0, yo);
            double y = func.apply(xp);

            if (yp < y) //
            {
                countIn++;
            }
        }
        double ag = (end - start) * yo;
        double integral = ag * (double) countIn / (double) shotCount;
        System.out.println("Integral : " + integral);
    }

    public static void main(String[] args)//
    {
        new MonteCarloMonoton2(d -> Math.exp(d * d), 2.0, 5.0, 1000 * 1000);
        new MonteCarloMonoton2(d -> Math.exp(-d * d), 2.0, 5.0, 1000 * 1000);
    }
}
