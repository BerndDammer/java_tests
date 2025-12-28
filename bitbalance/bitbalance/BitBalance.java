package bitbalance;

public class BitBalance
{

    private static final int PRE_1_LOW = 3;
    private static final int STEP_2_RISE = 2;
    private static final int LEVEL_3_HIGH = 3;
    private static final int STEP_4_FALL = 1;

    BitBalance()
    {
        int riseBits;
        int fallBits;
        int totalSteps;

        for (riseBits = 1; riseBits <= 4; riseBits++)
        {
            for (fallBits = 1; fallBits <= 8; fallBits++)
            {
                totalSteps = PRE_1_LOW;
                totalSteps += STEP_2_RISE * (int) Math.round(Math.pow(2.0, (double) (riseBits))) - 1;
                totalSteps += LEVEL_3_HIGH;
                totalSteps += STEP_4_FALL * (int) Math.round(Math.pow(2.0, (double) (fallBits))) - 1;

                double time = (double) totalSteps * 1e-6 / 16.0;
                double bps = (double) (riseBits + fallBits) / time;
                System.out.printf("\n%3d %3d %5d  Time %8.3e  bps %12.0f  bps %12.4f", riseBits, fallBits, totalSteps,
                        time, bps, (double) (riseBits + fallBits) / (double) totalSteps * 16.0);
            }
        }
    }

    public static void main(String[] args)
    {
        new BitBalance();
    }
}
