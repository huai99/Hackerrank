package algorithm.Graph_Theory.Even_Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static class Graph {
        int numOfNodes;
        LinkedList<Integer>[] adj;
        boolean[] visit;
        int[] numOfChild;
        int max = 0;

        Graph(int numOfNodes) {
            this.numOfNodes = numOfNodes;
            adj = new LinkedList[numOfNodes + 1];
            visit = new boolean[numOfNodes + 1];
            numOfChild = new int[numOfNodes + 1];
            for (int i = 0; i < numOfNodes + 1; i++) {
                adj[i] = new LinkedList();
                visit[i] = false;
            }
        }

        void addEdges(int num1, int num2) {
            // It is actually a directed graph that has parent-child relationship
            adj[num2].add(num1);
        }

        int dfs(int num) {
            int sum = 1;
            visit[num] = true;
            for (int number : adj[num]) {
                if (!visit[number]) {
                    sum += dfs(number);
                }
            }
            numOfChild[num] = sum;
            return sum;
        }

        void solve() {
            for (int i = 1; i < numOfChild.length - 1; i++) {
                if (numOfChild[i] % 2 == 0) {
                    max++;
                }
            }
            System.out.print(max);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfNodes = in.nextInt();
        int numberOfEdges = in.nextInt();
        Graph graph = new Graph(numberOfNodes);
        for (int i = 0; i < numberOfEdges; i++) {
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            graph.addEdges(num1, num2);
        }
        graph.dfs(1);
        graph.solve();
    }
}
