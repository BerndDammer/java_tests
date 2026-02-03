package test;

import static test.CONSTANTS.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ResultPrinter //
{

    public static void printResult(Alphabet a, CollectedAlphabet ca) //
    {
        int i;
        StringBuilder sb = new StringBuilder();
        char[] reg = new char[POW2_CODE];
        sb.append("------------ alphabet .....................\n");
        append(sb);
        for (i = 0; i < COUNT_DATA; i++)//
        {
            int code = a.get(i);
            bitShow(code, reg);
            sb.append( reg );
            sb.append(" | ");

            sb.append(i);
            sb.append(" | ");
            sb.append(code);
            sb.append(" | ");
            sb.append("\n");
            append(sb);
        }
        sb.append("------------ free codes .....................\n");
        append(sb);
        for (i = 0; i < COUNT_CODE; i++)//
        {
            if (!ca.get(i)) //
            {
                bitShow(i, reg);
                sb.append(reg);
                sb.append(" | ");
                sb.append(i);
                sb.append("\n");
                append(sb);
            }
        }
        sb.append("-------------- end ---------------------------\n");
        append(sb);
    }

    private static void append(StringBuilder sb) {
        try {
            Files.write(Paths.get("Result.log"), sb.toString().getBytes(), StandardOpenOption.WRITE,
                    StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            sb.setLength(0);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static void bitShow(int code, char[] reg) //
    {
        for (int i = reg.length - 1; i >= 0; i--) //
        {
            reg[i] = (code & 1) == 1 ? '*' : 'o';
            code >>= 1;
        }
    }
}
