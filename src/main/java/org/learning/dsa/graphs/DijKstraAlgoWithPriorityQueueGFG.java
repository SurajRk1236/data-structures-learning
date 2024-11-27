package org.learning.dsa.graphs;

import java.util.*;

public class DijKstraAlgoWithPriorityQueueGFG {
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(int n, List<List<Edge>> graph, int start) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE); // Initialize distances with infinity
        distances[start] = 0;

        // Min-heap priority queue to get the node with the smallest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > distances[node]) continue;

            for (Edge edge : graph.get(node)) {
                int newDist = distances[node] + edge.weight;
                if (newDist < distances[edge.target]) {
                    distances[edge.target] = newDist;
                    pq.offer(new int[]{edge.target, newDist});
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        List<List<Edge>> graph = new ArrayList<>();

        // Initializing adjacency list for graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges (source, target, weight)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));

        int startNode = 0;
        int[] distances = dijkstra(n, graph, startNode);

        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + " : " + (distances[i] == Integer.MAX_VALUE ? "Infinity" : distances[i]));
        }
    }
}
