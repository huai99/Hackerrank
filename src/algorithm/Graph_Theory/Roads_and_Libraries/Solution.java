package algorithm.Graph_Theory.Roads_and_Libraries;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    /*
    Refer to this solution and find out my problem
    https://www.hackerrank.com/rest/contests/master/challenges/torque-and-development/hackers/daniel_kinzler/download_solution
     */

    static class Graph {
        boolean[] visited;
        LinkedList<Integer>[] adj;
        int numberOfNodes;
        int minimumRoadNumber = 0;
        long minCost = 0;
        int numberOfDisconnectedRoad = 0;

        Graph(int n) {
            numberOfNodes = n;
            visited = new boolean[n];
            adj = new LinkedList[n];
            init();
        }

        void init() {
            for (int i = 0; i < numberOfNodes; i++) {
                adj[i] = new LinkedList<>();
                visited[i] = false;
            }
        }

        void addEdge(int a1, int a2) {
            adj[a1].add(a2);
            adj[a2].add(a1);
        }

        void bfs(int n) {
            visited[n] = true;
            LinkedList<Integer> queue = new LinkedList();
            queue.add(n);
            minimumRoadNumber = 0;
            while (!queue.isEmpty()) {
                int s = queue.poll();
                minimumRoadNumber++;
                for (int num : adj[s]) {
                    if (!visited[num]) {
                        visited[num] = true;
                        queue.add(num);
                    }
                }
            }
        }

        void solve(long cLib, long cRoad) {
            if (cRoad > cLib) {
                System.out.println(numberOfNodes * cLib);
            } else {
                for (int i = 0; i < numberOfNodes; i++) {
                    if (!visited[i]) {
                        bfs(i);
                        minCost += (minimumRoadNumber - 1) * cRoad + cLib;
                    }
                }
                System.out.println(minCost);

            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            Graph graph = new Graph(n);
            int m = in.nextInt();
            long x = in.nextLong();
            long y = in.nextLong();
            if (m == 0) {
                System.out.println(x * n);
            } else {
                for (int a1 = 0; a1 < m; a1++) {
                    int city_1 = in.nextInt() - 1;
                    int city_2 = in.nextInt() - 1;
                    graph.addEdge(city_1, city_2);
                }
                graph.solve(x, y);
            }
        }
    }

}
