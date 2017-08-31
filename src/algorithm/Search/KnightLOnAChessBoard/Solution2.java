package algorithm.Search.KnightLOnAChessBoard;

import java.util.Scanner;

public class Solution2 {
    /*
    Recursive solution and more intuitive
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(solve(i, j, n, new int[n][n]) + " ");
            }
            System.out.println();
        }
    }

    static int solve(int step_x, int step_y, int n, int[][] nt) {
        solve_recur(step_x, step_y, 0, 0, 1, nt);

        // Need to minus 1 because we start the sum from 1 instead of 0
        int result = nt[n - 1][n - 1] - 1;
        if (result == 0) {
            return -1;
        } else {
            return result;
        }
    }

    static void solve_recur(int step_x, int step_y, int posX, int posY, int sum, int[][] nt) {
        int n = nt.length;
        if (posX >= n || posY >= n || posX < 0 || posY < 0) {
            return;
        }

        if (nt[posX][posY] == 0 || sum < nt[posX][posY]) {
            nt[posX][posY] = sum;
            solve_recur(step_x, step_y, posX - step_x, posY - step_y, sum + 1, nt);
            solve_recur(step_x, step_y, posX - step_x, posY + step_y, sum + 1, nt);
            solve_recur(step_x, step_y, posX + step_x, posY - step_y, sum + 1, nt);
            solve_recur(step_x, step_y, posX + step_x, posY + step_y, sum + 1, nt);
            if (step_x != step_y) {
                solve_recur(step_x, step_y, posX - step_y, posY - step_x, sum + 1, nt);
                solve_recur(step_x, step_y, posX - step_y, posY + step_x, sum + 1, nt);
                solve_recur(step_x, step_y, posX + step_y, posY - step_x, sum + 1, nt);
                solve_recur(step_x, step_y, posX + step_y, posY + step_x, sum + 1, nt);
            }
        }
    }
}
