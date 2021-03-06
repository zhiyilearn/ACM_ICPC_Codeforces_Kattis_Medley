// https://www.geeksforgeeks.org/arrays-binarysearch-java-examples-set-1/
// Based on https://gist.github.com/WuChris/d8f4042f4aca0da2db32a13a61ec1ba8
// It is better than binarySearch.

import java.util.*;
public class ProblemA {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int n, q;
        n = sc.nextInt();
        int price;
        int[] freq = new int[100_001];
        Arrays.fill(freq,0);

        for (int i = 0; i < n; i++) {
            price = sc.nextInt();
            freq[price]++;
        }

        int[] prefixSums = buildprefixSum(freq);

        q = sc.nextInt();
        int money;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++)
        {
                money = sc.nextInt();
                sb.append(prefixSums[money] + "\n");
        }
        System.out.println(sb.toString());
    }

    public static int[] buildprefixSum(int[] Arr)
    {
            int[] prefixSum = new int[Arr.length];

            for(int i = 0; i < Arr.length; i++)
            {
                prefixSum[i] = Arr[i];
                if(i > 0)
                    prefixSum[i] += prefixSum[i-1];
            }
            return prefixSum;
    }
}
