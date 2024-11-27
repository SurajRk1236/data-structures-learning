package org.learning.dsa.graphs;
import java.util.*;
public class AilienDictionary269 {
    public static void main(String[] args) {

    }

    class Solution {
        public String findOrder(String[] dict, int n, int k) {
            List<List<Integer>> adjList = getAdjList(dict, n, k);
            int[] visited = getVisited(adjList, n, k);
            return getTopoSort(adjList, n, k, visited);
        }

        private List<List<Integer>> getAdjList(String[] dict, int n, int k){
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 0; i < k; i++){
                List<Integer> temp = new ArrayList<>();
                result.add(temp);
            }
            for(int i = 0; i < n - 1; i++){
                String first = dict[i];
                String second = dict[i + 1];
                int m = Math.min(first.length(), second.length());
                for(int j = 0; j < m; j++){
                    if(first.charAt(j) != second.charAt(j)){
                        result.get(first.charAt(j) - 'a').add(second.charAt(j) - 'a');
                        break;
                    }
                }
            }
            return result;
        }

        private int[] getVisited(List<List<Integer>> adjList, int n, int k){
            int[] result = new int[k];
            for(int i = 0; i < k; i++){
                for(int num : adjList.get(i)){
                    result[num]++;
                }
            }
            return result;
        }

        private String getTopoSort(List<List<Integer>> adjList, int n, int k, int[] visited){
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < k; i++){
                if(visited[i] == 0){
                    queue.offer(i);
                }
            }
            StringBuilder result = new StringBuilder();
            int counter = 0;
            while(!queue.isEmpty()){
                int node = queue.poll();
                result.append((char) node + 'a');
                counter++;
                for(int num : adjList.get(node)){
                    visited[num]--;
                    if(visited[num] == 0){
                        queue.offer(num);
                    }
                }
            }
            return result.toString();
        }
    }
}
