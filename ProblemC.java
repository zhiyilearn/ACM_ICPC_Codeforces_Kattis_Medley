// Code is based on VT ICPC handbook
import java.util.*;
public class ProblemC {
    static ArrayList<String> final_List;
    // static ArrayList<String> permuted_List;
    public static void main(String []av) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int k, m;
        k = sc.nextInt();
        m = sc.nextInt();

        char [] Letters = word.toCharArray();
        Arrays.sort(Letters);
        char [] comb = new char[k];
        final_List = new ArrayList<>();
        makecomb(Letters, 0, 0, comb);
        System.out.println(final_List.get(m-1));
    }

    static void makecomb(char [] a, int pos, int idx, char [] comb) {
         if (pos == comb.length) {
             // System.out.println(String.valueOf(comb));
             final_List.add(String.valueOf(comb));
             return;
             }

         for (int i = idx; i < a.length; i++) {
             comb[pos] = a[i];
             makecomb(a, pos + 1, i + 1, comb);
         }
    }

}
