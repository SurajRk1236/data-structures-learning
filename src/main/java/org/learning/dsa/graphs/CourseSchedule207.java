package org.learning.dsa.graphs;
import java.util.*;

public class CourseSchedule207 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjList = buildAdjList(prerequisites, numCourses);
            int V = adjList.size();
            System.out.println(adjList.toString());
            return getNumberOfElemntsPosiible(numCourses, adjList);
        }

        private List<List<Integer>> buildAdjList(int[][] prerequisites, int numCourses){
            List<List<Integer>> result = new ArrayList<>();
            int n = prerequisites.length;
            for(int i = 0; i < numCourses; i++){
                List<Integer> temp = new ArrayList<>();
                result.add(temp);
            }
            for(int i = 0; i < n; i++){
                int first = prerequisites[i][1];
                int second = prerequisites[i][0];
                result.get(first).add(second);
            }
            return result;
        }

        private boolean  getNumberOfElemntsPosiible(int numCourses, List<List<Integer>> adjList){
            Queue<Integer> queue = new LinkedList<>();
            int v = adjList.size();
            int[] visited = new int[v];
            for(int i = 0; i < v; i++){
                for(int num : adjList.get(i)){
                    visited[num]++;
                }
            }
            System.out.println(Arrays.toString(visited));
            for(int i = 0; i < v; i++){
                if(visited[i] == 0) queue.offer(i);
            }
            return numberOfElements(queue, visited, adjList) == numCourses;
        }

        private int numberOfElements(Queue<Integer> queue, int[] visited, List<List<Integer>> adjList){
            int counter = 0;
            while(!queue.isEmpty()){
                int node = queue.poll();
                counter++;
                for(int num : adjList.get(node)){
                    visited[num]--;
                    if(visited[num] == 0) queue.offer(num);
                }
            }
            return counter;
        }
    }
}
