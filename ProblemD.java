/*
@Author: Zhiyi Li
@Version: 2019/03/09
*/
import java.util.*;
public class ProblemD {
    public static class Leg{
        int from, to, height;
        Legs(int from, int to, int height)
        {
            this.from = from;
            this.to = to;
            this.height = height;
        }
    }

    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();

        // Key:Index, Value: Height
        Map<Integer,Leg> legs = new HashMap<>();

        for(int i = 0; i < K; i++)
        {
            int from = sc.nextInt();
            int to = from + 1;
            int height = sc.nextInt();
            legs.put(from, new Leg(from, to,height));
        }

        boolean[] vacate = new boolean[N];
        Arrays.fill(vacate, true);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
        {
            int idx = i;
            int height = 0;
            boolean settleDown = false;
            while(legs.containsKey(idx) && settleDown == false)
            {
                // Slide downward
                int target = legs.
                i
            }
        }
    }
}
