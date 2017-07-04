package algorithm.DynamicProgramming.Sherlock_and_Cost;

import java.util.*;
/*
Sherlock and Cost Solution
 */
public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            int n = in.nextInt();
            int high = 0, low = 0;
            int[] arrayB = new int[n];
            for (int j = 0; j < n; j++) {
                arrayB[j] = in.nextInt();
            }
            /*
            The idea is to calculate the cost of arrayB at ith position for both situation:
            Ending with 1 or Ending with arrayB[i]. So when we are calculating the cost
            for ith position we will take into account of the maximum cost at i-1th position
            for both situation, and in the end, we will just take the maximum between the
            two costs.
             */
            for (int k = 1; k < n; k++) {
                int high_to_low_diff = arrayB[k - 1] - 1;
                int high_to_high_diff = Math.abs(arrayB[k - 1] - arrayB[k]);
                int low_to_high_diff = arrayB[k] - 1;

                /*
                So for low_temp, what I am computing is actually the situation if ith ends with 1,
                and there will be two scenarios:
                1. The arrayB[i-1] will be low and the cost will be low + low_to_low
                2. The arrayB[i-1] will be high and the cost will be high + high_to_low
                 */
                int low_temp = Math.max(low, high_to_low_diff + high);
                int high_temp = Math.max(high + high_to_high_diff, low_to_high_diff + low);
                low = low_temp;
                high = high_temp;
            }

            /*
            In the end, what we will have is the cost for both scenario of the n-1th index
            which is the last index of arrayB ends with 1 and ends with B[i], we will
            take the maximum between these low and print out the answer
             */
            System.out.println(Math.max(high, low));
        }
    }
}

