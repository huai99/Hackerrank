package UniversityCodeSprint3.Erupting_Volcanoes;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] map = new int[n][n];
        for (int a0 = 0; a0 < m; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            recur(x, y, new boolean[n][n], map, w);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.print(max);
        in.close();
    }

    private static void recur(int x, int y, boolean[][] visit, int[][] map, int w) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, w});
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            int local_x = pop[0];
            int local_y = pop[1];
            int local_w = pop[2];
            if (local_x >= 0 && local_x < map.length && local_y >= 0 && local_y < map[0].length && !visit[local_x][local_y] && local_w > 0) {
                visit[local_x][local_y] = true;
                map[local_x][local_y] += local_w;
                queue.add(new int[]{local_x - 1, local_y - 1, local_w - 1});
                queue.add(new int[]{local_x, local_y - 1, local_w - 1});
                queue.add(new int[]{local_x + 1, local_y - 1, local_w - 1});
                queue.add(new int[]{local_x - 1, local_y, local_w - 1});
                queue.add(new int[]{local_x + 1, local_y, local_w - 1});
                queue.add(new int[]{local_x - 1, local_y + 1, local_w - 1});
                queue.add(new int[]{local_x + 1, local_y + 1, local_w - 1});
                queue.add(new int[]{local_x, local_y + 1, local_w - 1});
            }
        }

        //Depth First Search is not suitable for our solution
       /* if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && !visit[x][y] && w > 0) {
            visit[x][y] = true;
            map[x][y] += w;
            recur(x - 1, y - 1, visit, map, w - 1);
            recur(x, y - 1, visit, map, w - 1);
            recur(x + 1, y - 1, visit, map, w - 1);
            recur(x - 1, y, visit, map, w - 1);
            recur(x + 1, y, visit, map, w - 1);
            recur(x - 1, y + 1, visit, map, w - 1);
            recur(x, y + 1, visit, map, w - 1);
            recur(x + 1, y + 1, visit, map, w - 1);
        }*/
    }
}