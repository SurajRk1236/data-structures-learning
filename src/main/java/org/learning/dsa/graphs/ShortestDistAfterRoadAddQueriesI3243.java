package org.learning.dsa.graphs;

import java.util.*;

public class ShortestDistAfterRoadAddQueriesI3243 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            // Adjacency list to represent the graph
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
                if (i < n - 1) graph.get(i).add(i + 1); // Initial path 0 -> 1 -> ... -> n-1
            }

            // Result array to store shortest paths after each query
            int[] result = new int[queries.length];

            // Dijkstra's algorithm function to find shortest path from 0 to n-1


            // Process each query
            for (int i = 0; i < queries.length; i++) {
                int u = queries[i][0];
                int v = queries[i][1];

                // Add the new road
                graph.get(u).add(v);

                // Compute shortest path from 0 to n-1
                result[i] = dijkstra(n, graph);
            }

            return result;
        }


        private int dijkstra(int n, List<List<Integer>> graph) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{0, 0}); // {node, distance}
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[0] = 0;

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int node = current[0], dist = current[1];

                if (dist > distances[node]) continue;

                for (int neighbor : graph.get(node)) {
                    int newDist = dist + 1;
                    if (newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                        pq.offer(new int[]{neighbor, newDist});
                    }
                }
            }

            return distances[n - 1];
        }
    }

}
