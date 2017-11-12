package algorithm.Search.Maximum_Subarray_Sum;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long maximumSum(long[] a, long m) {
        long max = Long.MIN_VALUE;
        for (int group = 0; group < a.length; group++) {
            for (int start = 0; start < a.length; start++) {
                long result = recur(start, group, a, m);
                max = Math.max(max, result);
                if (result == m - 1) {
                    return m - 1;
                }
            }
        }
        return max;
    }

    static long recur(int start, int group, long[] arr, long m) {
        int k = start + 1;
        long group_sum = 0;
        long max = Long.MIN_VALUE;
        while (k + group <= arr.length) {
            for (int j = k; j < k + group; j++) {
                group_sum += arr[j];
            }
            group_sum += arr[start];
            group_sum = group_sum % m;
            max = Math.max(group_sum, max);
            k++;
            group_sum = 0;
        }
        return max;
    }

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
            long result = maximumSum(a, m);
            System.out.println(result);
        }
        in.close();
    }
}