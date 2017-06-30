package algorithm.Search.KnightLOnAChessBoard;


import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    static class Node {
        public int x;
        public int y;
        public int t;

        Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (j >= i) {
                    grid[i][j] = getDistance(i, j, n);
                }else{
                    grid[i][j] = grid[j][i];
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getDistance(int i, int j, int n) {
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(new Node(0, 0, 0));
        boolean[][] visited = new boolean[n][n];
        while (linkedList.size() != 0) {
            Node node = linkedList.remove();
            int x = node.x;
            int y = node.y;
            int t = node.t;
            if (x - i >= 0) {
                if (y + j < n) {
                    addPoint(x-i, y+j, t + 1, linkedList, visited);
                }

                if (y - j >= 0) {
                    addPoint(x-i, y-j, t + 1, linkedList, visited);
                }
            }
            if (x + i < n) {
                if (y + j < n) {
                    if (x+i == n - 1 && y+j == n - 1) return t + 1;
                    addPoint(x+i, y+j, t + 1, linkedList, visited);
                }

                if (y - j >= 0) {
                    addPoint(x+i, y-j, t + 1, linkedList, visited);
                }
            }
            if (x - j >= 0) {
                if (y + i < n) {
                    addPoint(x-j, y+i, t + 1, linkedList, visited);
                }

                if (y - i >= 0) {
                    addPoint(x-j, y-i, t + 1, linkedList, visited);
                }
            }
            if (x + j < n) {
                if (y + i < n) {
                    if (x+j == n - 1 && y+i == n - 1) return t + 1;
                    addPoint(x+j, y+i, t + 1, linkedList, visited);
                }

                if (y - i >= 0) {
                    addPoint(x+j, y-i, t + 1, linkedList, visited);
                }
            }
        }
        return -1;
    }

    public static void addPoint(int x, int y, int t, LinkedList<Node> list, boolean[][] visited) {
        if (visited[x][y]) return;
        list.add(new Node(x, y, t));
        visited[x][y] = true;
    }
}
