package algorithm.Search.Maximum_Subarray_Sum;

import java.util.Scanner;
import java.util.TreeSet;

/*The idea of this is very tricky, it requires some mathematical understanding
  but is nevertheless an interesting question. Links to reference:
  https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextLong();
            }
            System.out.println(solve(a, m));
        }
        in.close();
    }

    public static long solve(long[] A, long m) {
        int length = A.length;
        long[] prefix_sum = new long[length];
        long running_sum = 0;
        for (int i = 0; i < length; i++) {
            running_sum += A[i];
            prefix_sum[i] = running_sum % m;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        long max = Long.MIN_VALUE;
        //Key idea is why are we looking for the smallest bigger number. Please look at the explaination below:
        for (int i = 0; i < length; i++) {
            Long higher = treeSet.higher(prefix_sum[i]);
            if (higher == null) {
                higher = 0L;
            }
            /* prefix[i] - higher + m, if (prefix[i] - higher) is positive, after
               adding with m and modulus with m, it will be prefix[i] - higher, which is
               smaller than prefix[i]. If (prefix[i]-higher) is negative, after
               adding with m and modulus with m, you have a better chance in getting a bigger number
               but you only want this negative number to be so small that it only minus a little bit from
               m, so that you can get the largest value after modulus with m !
             */
            long result = (prefix_sum[i] - higher + m) % m;
            max = Math.max(result, max);
        }
        return max;
    }
}
