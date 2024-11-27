package org.learning.dsa.graphs;

import java.util.*;

public class FindChampionII2924 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findChampion(int n, int[][] edges) {
            int[] visited = new int[n];
            List<List<Integer>> adjList = getAdjList(n, edges, visited);
            int counter = 0;
            int ans = 0;
            for(int i = 0; i < n; i++){
                if(visited[i] == 0){
                    counter++;
                    ans = i;
                }
            }
            return counter == 1 ? ans : -1;
        }

        private List<List<Integer>> getAdjList(int n, int[][] edges, int[] visited){
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 0; i < n; i++){
                result.add(new ArrayList<>());
            }

            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                result.get(v).add(u);
                visited[v]++;
            }
            return result;
        }
    }
}
