package Week_Of_Code_34.Maximum_Gcd_and_Sum;

import java.util.Scanner;

public class Solution {

    static int maximumGcdAndSum(int[] A, int[] B, int maxA, int maxB) {
        boolean[] inA = new boolean[1000001];
        boolean[] inB = new boolean[1000001];
        int max = Math.max(maxA, maxB);
        for (int i = 0; i < A.length; i++) {
            inA[A[i]] = true;
        }
        for (int i = 0; i < B.length; i++) {
            inB[B[i]] = true;
        }

        /*
        This is the step that is checking for gcd
         */
        for (int i = max; i >= 0; i--) {
            int a = 0, b = 0;
            int j = i;
            while (j <= max) {
                if (inA[j]) a = j;
                if (inB[j]) b = j;
                j += i;
            }
            if (a > 0 && b > 0) return a + b;
        }
        //If the maximum gcd is 1 then return the sum of maxA and maxB
        return maxA + maxB;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE;
        for (int A_i = 0; A_i < n; A_i++) {
            A[A_i] = in.nextInt();
            maxA = Math.max(A[A_i], maxA);
        }
        int[] B = new int[n];
        for (int B_i = 0; B_i < n; B_i++) {
            B[B_i] = in.nextInt();
            maxB = Math.max(B[B_i], maxB);
        }
        int res = maximumGcdAndSum(A, B, maxA, maxB);
        System.out.println(res);
    }
}
