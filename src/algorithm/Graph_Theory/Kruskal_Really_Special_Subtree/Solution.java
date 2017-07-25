package algorithm.Graph_Theory.Kruskal_Really_Special_Subtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static class Edges {
        int src, dest, weight;

        Edges(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Subset {
        int rank;
        int parent;
    }

    static class Graph {
        int numberOfNodes;
        int numberOfEdges;
        ArrayList<Edges> edgesList;

        Graph(int n, int e) {
            numberOfNodes = n;
            numberOfEdges = e;
            edgesList = new ArrayList<>();
        }

        void addEdge(Edges edges) {
            edgesList.add(edges);
        }
        /*
        Find and union are the function that helps detect cycle in the graph
         */
        int find(Subset[] subsets, int k) {
            if (subsets[k].parent != k) {
                subsets[k].parent = find(subsets, subsets[k].parent);
            }
            return subsets[k].parent;
        }

        void union(Subset[] subsets, int k1, int k2) {
            int xroot = find(subsets, k1);
            int yroot = find(subsets, k2);
            if (subsets[xroot].rank > subsets[yroot].rank) {
                subsets[yroot].parent = xroot;
            } else if (subsets[yroot].rank > subsets[xroot].rank) {
                subsets[xroot].parent = yroot;
            } else {
                subsets[xroot].parent = yroot;
                subsets[yroot].rank++;
            }
        }

        void solve() {
            Subset[] subset = new Subset[numberOfNodes];
            ArrayList<Edges> result = new ArrayList<>();
            edgesList.sort(new Comparator<Edges>() {
                @Override
                public int compare(Edges o1, Edges o2) {
                    return o1.weight - o2.weight;
                }
            });
            for (int i = 0; i < numberOfNodes; i++) {
                subset[i] = new Subset();
                subset[i].parent = i;
                subset[i].rank = 0;
            }
            int k = 0;
            int j=0;
            while (k < numberOfNodes - 1) {
                Edges next_edge = edgesList.get(j);
                j++;
                int x = find(subset, next_edge.src);
                int y = find(subset, next_edge.dest);

                //if there is no cycle formed adding the new_edge, then add it into the result set
                if (x != y) {
                    result.add(next_edge);
                    k++;
                    union(subset, x, y);
                }
            }
            int totalWeight = 0;
            for (Edges edges : edgesList) {
                totalWeight += edges.weight;
            }
            System.out.println(totalWeight);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        Graph graph = new Graph(n, e);
        for (int i = 0; i < e; i++) {
            int src = in.nextInt();
            int dest = in.nextInt();
            int weight = in.nextInt();
            Edges edges = new Edges(src, dest, weight);
            graph.addEdge(edges);
        }
        graph.solve();
    }
}
