package algorithm.Search.Count_Luck;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static class Node {
        int cX;
        int cY;

        Node(int cX, int cY) {
            this.cX = cX;
            this.cY = cY;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int m = in.nextInt();

            String[][] map = new String[n][m];

            Node start = null;
            for (int p = 0; p < n; p++) {
                char[] input = in.next().toCharArray();
                for (int q = 0; q < m; q++) {
                    if (input[q] == 'M') {
                        start = new Node(p, q);
                    }
                    map[p][q] = String.valueOf(input[q]);
                }
            }
            int val = dfs(start, new boolean[n][m], map, 0)[1];
            System.out.println(val);
            int k = in.nextInt();
            if (val == k) {
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }
        }
    }

    /* The first number in the return array is recording whether it found '*', the second is
       to record the how many times Hermione waves
    */
    public static int[] dfs(Node begin, boolean[][] used, String[][] map, int cT) {
        int cX = begin.cX;
        int cY = begin.cY;
        if (map[cX][cY].equals("*"))
            return new int[]{1, cT};

        used[cX][cY] = true;
        ArrayList<Node> listNode = getPoss(begin, used, map);
        if (listNode.size() == 0) {
            return new int[]{0, 0};
        } else if (listNode.size() == 1) {
            return dfs(listNode.get(0), used, map, cT);
        } else {
            for (Node node : listNode) {

                int[] cur = dfs(node, used, map, cT + 1);
                if (cur[0] == 1) return cur;
            }
        }
        return new int[]{0, 0};
    }


    /*
    This is getting the available next step for the position
     */
    public static ArrayList<Node> getPoss(Node begin, boolean[][] used, String[][] map) {
        ArrayList<Node> nodeList = new ArrayList<>();
        int cX = begin.cX;
        int cY = begin.cY;
        if (cX > 0 && !used[cX - 1][cY] && !map[cX - 1][cY].equals("X"))
            nodeList.add(new Node(cX - 1, cY));
        if (cY > 0 && !used[cX][cY - 1] && !map[cX][cY - 1].equals("X"))
            nodeList.add(new Node(cX, cY - 1));
        if (cX < map.length - 1 && !used[cX + 1][cY] && !map[cX + 1][cY].equals("X"))
            nodeList.add(new Node(cX + 1, cY));
        if (cY < map[0].length - 1 && !used[cX][cY + 1] && !map[cX][cY + 1].equals("X"))
            nodeList.add(new Node(cX, cY + 1));

        return nodeList;
    }
}
