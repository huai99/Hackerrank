package algorithm.DynamicProgramming.The_Maximum_Subarray;

import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            long continuousSum = 0;
            long non_continuousSum = 0;
            long max = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                //Compute contiguous sum
                int num = in.nextInt();
                continuousSum += num;
                max = (continuousSum > max) ? continuousSum : max;
                if (continuousSum < 0) {
                    continuousSum = 0;
                }
                //Compute non-contiguous sum
                non_continuousSum = (num > 0) ? non_continuousSum + num : non_continuousSum;
            }

            //Account for the case where the whole array is negative number
            if (max < 0) {
                System.out.println(max + " " + max);
            } else {
                System.out.println(max + " " + non_continuousSum);
            }
        }
    }
}

