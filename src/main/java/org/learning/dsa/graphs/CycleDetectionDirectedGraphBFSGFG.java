package org.learning.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionDirectedGraphBFSGFG {
    //kahns algo bieng used

    public static void main(String[] args) {

    }

    public boolean isCyclic(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int num : graph[i]) {
                visited[num]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int num : graph[node]) {
                visited[num]--;
                if (visited[num] == 0) {
                    queue.offer(num);
                }
            }
        }

        return result.size() == n;
    }
}
