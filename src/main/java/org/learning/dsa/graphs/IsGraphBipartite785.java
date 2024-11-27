package org.learning.dsa.graphs;

public class IsGraphBipartite785 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            Boolean[] colored = new Boolean[n]; // null = uncolored, true = color1, false = color2

            for (int i = 0; i < n; i++) {
                // Start DFS from each uncolored node to cover disconnected components
                if (colored[i] == null && !dfs(graph, i, colored, true)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int[][] graph, int node, Boolean[] colored, boolean color) {
            // If the node is already colored, check for consistency
            if (colored[node] != null) {
                return colored[node] == color;
            }

            // Color the node
            colored[node] = color;

            // Traverse all neighbors
            for (int neighbor : graph[node]) {
                // Recursively color the neighbor with the opposite color
                if (!dfs(graph, neighbor, colored, !color)) {
                    return false;
                }
            }
            return true;
        }
    }
}
