package org.learning.dsa.graphs;
import java.util.*;

public class FindEventualSafeStates802 {
    public static void main(String[] args) {

    }


    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] visited = new int[n];
            List<List<Integer>> revAdjList = getReversedAdjList(n, graph);
            System.out.println(revAdjList.toString());
            markValuesVisited(n, visited, revAdjList);
            System.out.println(Arrays.toString(visited));
            return getSafeStates(n, revAdjList, visited);
        }

        private List<List<Integer>> getReversedAdjList(int n, int[][] graph){
            List<List<Integer>> revAdjList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                List<Integer> temp = new ArrayList<>();
                revAdjList.add(temp);
            }

            for(int i = 0; i < n; i++){
                int m = graph[i].length;
                for(int j = 0; j < m; j++){
                    revAdjList.get(j).add(i);
                }
            }
            return revAdjList;
        }

        private void markValuesVisited(int n, int[] visited, List<List<Integer>> revAdjList){
            for(int i = 0; i < n; i++){
                for(int num : revAdjList.get(i)){
                    visited[num]++;
                }
            }
        }

        private List<Integer> getSafeStates(int n, List<List<Integer>> revAdjList, int[] visited ){
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(visited[i] == 0){
                    queue.offer(i);
                }
            }

            while(!queue.isEmpty()){
                int node = queue.poll();
                result.add(node);
                for(int num : revAdjList.get(node)){
                    visited[num]--;
                    if(visited[num] == 0)  queue.offer(num);
                }
            }
            Collections.sort(result);
            return result;
        }
    }
}
