package algorithm.Graph_Theory.Snakes_and_Ladders;

import java.util.*;

public class Solution {

    /*
    Inspiration for solving this problem:
    http://theoryofprogramming.com/2014/12/25/snakes-and-ladders-game-code/
     */

    static class Node {
        int value;
        int sum;

        Node(int value, int sum) {
            this.value = value;
            this.sum = sum;
        }
    }

    static class Graph {
        int numOfNodes;
        LinkedList<Integer>[] adj;
        boolean[] visit;
        int[] numOfChild;

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

        void addEdges(int parent, int child) {
            // It is actually a directed graph that has parent-child relationship
            adj[parent].add(child);
        }

        int bfs() {
            visit[1] = true;
            LinkedList<Node> queue = new LinkedList();
            queue.add(new Node(1, 0));
            while (!queue.isEmpty()) {
                Node item = queue.pollFirst();
                for (int num : adj[item.value]) {
                    if (!visit[num]) {
                        visit[num] = true;
                        if (num == 100) {
                            return item.sum + 1;
                        }
                        queue.add(new Node(num, item.sum + 1));
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            Graph graph = new Graph(100);

            int numLadders = in.nextInt();
            HashMap<Integer, Integer> ladderMap = new HashMap<>();
            for (int j = 0; j < numLadders; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                ladderMap.put(start, end);
            }

            int numSnakes = in.nextInt();
            HashMap<Integer, Integer> snakeMap = new HashMap<>();
            for (int j = 0; j < numSnakes; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                snakeMap.put(start, end);
            }

            int k = 1;
            /*
            Link your node to where you can reach in the next 6 steps, if your ending point is a special number (bottom
            of ladder or head of snakes, then link to node where the special number leads ( top of ladder, tail of snakes)
             */
            while (k <= 100) {
                for (int j = 1; j <= 6; j++) {

                    //If it contains the head of snakes or the bottom of the ladder, just skip
                    if (snakeMap.containsKey(k) || ladderMap.containsKey(k)) {
                        break;
                    }
                    // If your ending point is the head of snake, then link you directly to the tail of snakes
                    if (snakeMap.containsKey(k + j)) {
                        graph.addEdges(k, snakeMap.get(k + j));
                    }
                    // If your ending point is the bottom of ladder, then link you directly to the bottom of ladders
                    if (ladderMap.containsKey(k + j)) {
                        graph.addEdges(k, ladderMap.get(k + j));
                    }
                    if (k + j > 100) {
                        break;
                    }
                    graph.addEdges(k, k + j);
                }
                k++;
            }

            System.out.println(graph.bfs());
        }
    }

}