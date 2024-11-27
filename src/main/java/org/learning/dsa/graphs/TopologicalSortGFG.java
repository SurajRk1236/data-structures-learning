package org.learning.dsa.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortGFG {
    public static void main(String[] args) {

    }

    public List<Integer> topologicalSort(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, stack, visited);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void dfs(int i, int[][] graph, Stack<Integer> stack, boolean[] visited) {
        visited[i] = true;
        for (int num : graph[i]) {
            if (!visited[num]) {
                dfs(num, graph, stack, visited);
            }
        }
        stack.push(i);
    }
}
