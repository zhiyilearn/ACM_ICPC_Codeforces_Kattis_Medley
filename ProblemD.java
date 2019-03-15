/*
@Author: Zhiyi Li
@Date: 2019/03/09 ProblemD Thanos The Hero
*/
import java.util.*;
public class ProblemF {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] population = new long[N];
        for(int i = 0; i < N; i++)
        {
            population[i] = sc.nextLong();
        }

        boolean impossible = false;

        if( N == 1)
        {
            System.out.println(0);
            return;
        }

        int count = 0;
        for(int i = N -2; i >= 0; i--)
        {
            // Compare i+1 and i elements
            if(population[i+1] > population[i])
                continue;

            long expect_i = population[i+1] - 1;
            if(expect_i < 0)
            {
                impossible = true;
                break;
            }

            count += population[i] - expect_i;
            population[i] = expect_i;
        }

        if(impossible == true)
            System.out.println(1);
        else
            System.out.println(count);
    }
}
