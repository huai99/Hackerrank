package algorithm.Constructive_Algorithm.Flipping_the_Matrix;

import java.util.Scanner;

public class Solution {

    /*
    The idea of this solution is quite special, first we need to have this idea that this matrix will be separated into
    4 quadrant, and if we are allowed to reverse any row or column any time as we wish, we will be able to move
    the number on index (2n-1-i,j),(i,2n-1-j),(2n-1-i,2n-1-j) to index (i,j) without affecting the position of other
    number. By having this idea, we just get the maximum among these four position and sum up all of them
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int k = 0; k < q; k++) {
            int max = 0;
            int n = in.nextInt();
            int[][] matrix = new int[2 * n][2 * n];
            for (int i = 0; i < 2 * n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int endingIndex = 2 * n - 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max += getMax(matrix[i][j], matrix[endingIndex - i][j], matrix[endingIndex - i][endingIndex - j], matrix[i][endingIndex - j]);
                }
            }
            System.out.println(max);
        }
    }

    public static int getMax(int a, int b, int c, int d) {
        int max = Integer.MIN_VALUE;
        if (a > max) {
            max = a;
        }
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (d > max) {
            max = d;
        }
        return max;
    }
}
