package algorithm.Search.Connected_Cells_in_a_Grid;

import java.util.Scanner;

public class Solution {
    static int[][] matrix;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;
        matrix = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                matrix[i][k] = in.nextInt();
            }
        }
        in.close();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                max = Math.max(dfs(n, m, i, k), max);
            }
        }
        System.out.println(max);
    }

    public static int dfs(int n, int m, int targetN, int targetM) {
        int count = 0;
        if (targetN < 0 || targetM < 0 || targetN >= n || targetM >= m) {
            return 0;
        }
        if (!visited[targetN][targetM]) {
            visited[targetN][targetM] = true;
            //Account for the 8 directions that it needs to factor in
            if (matrix[targetN][targetM] == 1) {
                count++;
                count += dfs(n, m, targetN + 1, targetM);
                count += dfs(n, m, targetN, targetM + 1);
                count += dfs(n, m, targetN, targetM - 1);
                count += dfs(n, m, targetN - 1, targetM);
                count += dfs(n, m, targetN + 1, targetM - 1);
                count += dfs(n, m, targetN + 1, targetM + 1);
                count += dfs(n, m, targetN - 1, targetM - 1);
                count += dfs(n, m, targetN - 1, targetM + 1);
            }

        }
        return count;
    }
}
