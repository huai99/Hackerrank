package algorithm.Search.Cut_the_Tree;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static class Graph {
        int numOfNodes;

        Graph(int numberOfNodes) {
            this.numOfNodes = numberOfNodes;
        }

        void addEdge(Vertex[] adj, int a1, int a2) {
            adj[a1].addEdge(adj[a2]);
            adj[a2].addEdge(adj[a1]);
        }

        int dfs(Vertex v1, boolean[] visited) {
            visited[v1.id] = true;
            for (Vertex v : v1.list) {
                if (!visited[v.id]) {
                    v1.subtreeValue += dfs(v, visited);
                }
            }
            return v1.subtreeValue;
        }

        int min = Integer.MAX_VALUE;

        void dfsEnt(Vertex v1, boolean[] visited, int total) {
            visited[v1.id] = true;

            // The requirement of the question
            int curMin = Math.abs(total - 2 * v1.subtreeValue);

            min = Math.min(curMin, min);
            for (Vertex v : v1.list) {
                if (!visited[v.id]) {
                    dfsEnt(v, visited, total);
                }
            }
        }
    }

    static class Vertex {
        int value;
        int id;
        int subtreeValue;
        LinkedList<Vertex> list;

        Vertex(int id, int value) {
            this.id = id;
            this.value = value;
            list = new LinkedList<>();
            this.subtreeValue = value;
        }

        void addEdge(Vertex v) {
            list.add(v);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Graph graph = new Graph(n);
        int sum = 0;
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            sum += value;
            Vertex vertex = new Vertex(i, value);
            vertices[i] = vertex;
        }
        for (int i = 0; i < n - 1; i++) {
            graph.addEdge(vertices, in.nextInt() - 1, in.nextInt() - 1);
        }
        graph.dfs(vertices[0], new boolean[n]);
        graph.dfsEnt(vertices[0], new boolean[n], sum);
        System.out.println(graph.min);
    }
}
