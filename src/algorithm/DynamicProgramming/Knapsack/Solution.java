package algorithm.DynamicProgramming.Knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] A = new int[n];
            for (int j = 0; j < n; j++) {
                A[j] = in.nextInt();
            }
            //Sort the array first
            Arrays.sort(A);
            System.out.println(find(A, k, 0));
        }
    }

    public static int find(int[] A, int targetNumber, int sum) {
        int max = Integer.MIN_VALUE;
        int length = A.length;
        //Start from the biggest number and if find the targetNumber then break
        // Avoid using smaller number to iterate
        for (int i = length-1; i > -1; i--) {
            if (sum + A[i] <= targetNumber) {
                max = Math.max(find(A, targetNumber, sum + A[i]), max);
                if (max == targetNumber) break;
            } else {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
