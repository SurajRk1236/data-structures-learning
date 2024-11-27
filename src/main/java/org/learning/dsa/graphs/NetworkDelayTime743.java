package org.learning.dsa.graphs;

import java.util.*;

public class NetworkDelayTime743 {
    public static void main(String[] args) {

    }

    class Solution {

        class Pair {
            int node;
            int time;

            Pair(int node, int time) {
                this.node = node;
                this.time = time;
            }
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            // Step 1: Create adjacency list
            List<List<Pair>> adjList = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];
                adjList.get(u).add(new Pair(v, w));
            }

            // Step 2: Initialize distances array
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[k] = 0;

            // Step 3: Use priority queue for Dijkstra's algorithm
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
            pq.offer(new Pair(k, 0));

            while (!pq.isEmpty()) {
                Pair current = pq.poll();
                int currentNode = current.node;
                int currentTime = current.time;

                // Skip if this is not the shortest path to the node
                if (currentTime > dist[currentNode]) continue;

                // Step 4: Update neighbors
                for (Pair neighbor : adjList.get(currentNode)) {
                    int nextNode = neighbor.node;
                    int timeToNextNode = neighbor.time;
                    int newTime = currentTime + timeToNextNode;

                    if (newTime < dist[nextNode]) {
                        dist[nextNode] = newTime;
                        pq.offer(new Pair(nextNode, newTime));
                    }
                }
            }

            // Step 5: Find the maximum time to reach all nodes
            int maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE) return -1; // Unreachable node
                maxTime = Math.max(maxTime, dist[i]);
            }

            return maxTime;
        }
    }
}
