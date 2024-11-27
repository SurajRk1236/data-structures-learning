package org.learning.dsa.graphs;

public class CycleDetectionInDirectedGraphGFG {
    public static void main(String[] args) {
        
    }
    public boolean isCyclicGraph(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, path, graph[i])) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, boolean[] visited, boolean[] path, int[] graph) {
        visited[i] = true;
        path[i] = true;
        for (int num : graph){
            if (!visited[num]) {
                if (dfs(num, visited, path, graph)) return true;
            } else if (path[num]) return true;
        }
        
        path[i] = false;
        return false;
    }
}
