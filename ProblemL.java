import java.util.*;
import java.lang.*;
import java.io.*;
public class ProblemL {

    public static void main(String[] argc)
    {
        FastScanner sc = new FastScanner();

        int  N = 20000001;
        boolean [] isPrime = sieve(N);

        int Q = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++)
        {
            int candidate = sc.nextInt();
            sb.append(NPF(candidate, isPrime)+ "\n");
        }

        PrintWriter io = new PrintWriter(new BufferedOutputStream(System.out));
        io.print(sb.toString());
        io.close();
    }

    static boolean [] sieve(int N) {
        boolean [] a = new boolean[N+1];
        Arrays.fill(a, true);
        a[0] = a[1] = false;
        for (int p = 2; p*p <= N; p++)
            if (a[p]) {
                // Iterate through all multiples of the prime and mark them
                // as not prime.
                for (int m = p*p; m <= N; m += p)
                    a[m] = false;
            }
        return a;
    }

    public static int NPF(int candidate, boolean[] isPrime)
    {
        int res = 0;
        for(int i = 1; i<= candidate; i++)
        {
            if( candidate % i == 0 && !isPrime[i] ) {
                // System.out.println(i);
                res++;
            }
        }
        return res;
    }

    public static class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(Reader in)
        {
            br = new BufferedReader(in);
        }
        public FastScanner() { this(new InputStreamReader(System.in)); }

        String next() {
            while (st == null || !st.hasMoreElements())
            {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        // Slightly different from java.util.Scanner.nextLine(),
        // which returns any remaining characters in current line,
        // if any.
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++)
            {
                a[idx] = nextInt();
            }
            return a;
        }
        long[] readLongArray(int n)
        {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}
