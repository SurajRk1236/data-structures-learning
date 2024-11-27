package org.learning.dsa.graphs;

import java.util.*;

public class CheapestFlightWithKstops787 {
    public static void main(String[] args) {

    }

    class Solution {

        class Pair{
            int dest;
            int dist;
            Pair(int dest, int dist){
                this.dest = dest;
                this.dist = dist;
            }
        }

        class Tuple{
            int stop;
            int src;
            int dist;
            Tuple(int stop, int src, int dist){
                this.stop = stop;
                this.src = src;
                this.dist = dist;
            }
        }

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<Pair>> adjList = getAdjList(n, flights);
            for (int i = 0; i < adjList.size(); i++) {
                System.out.print("Node " + i + " -> ");
                for (Pair pair : adjList.get(i)) {
                    System.out.print(pair.dist + " " + pair.dest);
                }
                System.out.println();
            }
            int[] distance = getDistance(n);
            return getCheapestPrice(n, adjList, src, dst, k, distance);
        }


        private List<List<Pair>> getAdjList(int n, int[][] flights){
            List<List<Pair>> adjList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                List<Pair> temp = new ArrayList<>();
                adjList.add(temp);
            }

            for (int i = 0; i < flights.length; i++) {
                int source = flights[i][0];
                int dest = flights[i][1];
                int dist = flights[i][2];
                adjList.get(source).add(new Pair(dest, dist));
            }
            return adjList;
        }

        private int[] getDistance(int n){
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            return distance;
        }

        private int getCheapestPrice(int n, List<List<Pair>> adjList, int source, int dst, int k, int[] distanceArr ){
            Queue<Tuple> queue = new LinkedList<>();
            queue.offer(new Tuple(0, source, 0));
            while(!queue.isEmpty()){
                Tuple tup = queue.poll();

                int stop = tup.stop;
                int src = tup.src;
                int dist = tup.dist;
                System.out.println("Stop" + stop + "src" + src + "dist" + dist);
                if(stop > k) continue;
                for(Pair pair : adjList.get(src)){
                    int dest = pair.dest;
                    int distance = pair.dist;
                    int newDistance = distance + dist;
                    if(checkValidDistance(newDistance, stop, k, distanceArr, dest)){
                        distanceArr[dest] = newDistance;
                        queue.offer(new Tuple(stop + 1, dest, newDistance));
                    }
                }
            }
            return distanceArr[dst] == Integer.MAX_VALUE ? -1 : distanceArr[dst];
        }

        private boolean checkValidDistance(int newDist, int newStop, int kStop, int[] distanceArr, int dest){
            return distanceArr[dest] > newDist && newStop <= kStop;
        }
    }
}
