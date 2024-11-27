package org.learning.dsa.graphs;

import java.util.*;

public class NumberOfWaysToArriveAtDestination1976 {
    public static void main(String[] args) {

    }

    class Solution {
        int mod = (int) (1e9 + 7);

        public int countPaths(int n, int[][] roads) {
            // build the ajacency list, int[] {cityNumber, time needed}
            List<List<int[]>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] road : roads) { // bi-directional
                adj.get(road[0]).add(new int[] {road[1], road[2]});
                adj.get(road[1]).add(new int[] {road[0], road[2]});
            }

            // track the paths
            long[] numOfPaths = new long[n];
            long[] shortestTimes = new long[n];
            numOfPaths[0] = 1;
            shortestTimes[0] = 0;
            Arrays.fill(shortestTimes, Long.MAX_VALUE);


            // performing a bfs with priorityQueue to find the shortest amount of time
            PriorityQueue<long[]> heap = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1])); // minHeap
            heap.add(new long[]{0, 0});
            while (!heap.isEmpty()) {
                long[] curr = heap.poll();
                int city = (int) curr[0];
                long time = curr[1];

                for (int[] neighbor : adj.get(city)) {
                    int neighborCity = neighbor[0];
                    long neighborTime = neighbor[1];
                    if (time + neighborTime > shortestTimes[neighborCity] || time + neighborTime > shortestTimes[n - 1]) {
                        continue;
                    }

                    if (time + neighborTime == shortestTimes[neighborCity]) {
                        numOfPaths[neighborCity] = (numOfPaths[neighborCity] + numOfPaths[city]) % mod;
                    } else {
                        shortestTimes[neighborCity] = time + neighborTime;
                        numOfPaths[neighborCity] = numOfPaths[city];
                        heap.offer(new long[] {neighborCity, neighborTime + time});
                    }

                }
            }

            return (int) (numOfPaths[n - 1] % mod);
        }
    }
}
