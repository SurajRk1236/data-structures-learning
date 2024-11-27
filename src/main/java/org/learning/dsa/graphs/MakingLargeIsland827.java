package org.learning.dsa.graphs;

import java.util.HashSet;
import java.util.Set;

public class MakingLargeIsland827 {
    public static void main(String[] args) {

    }

    class Solution {
        class DisjointSet {
            int[] parent;
            int[] size;

            DisjointSet(int n) {
                parent = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            int findParent(int node) {
                if (node == parent[node]) return node;
                return parent[node] = findParent(parent[node]); // Path compression
            }

            void linkNodeBySize(int u, int v) {
                int uParent = findParent(u);
                int vParent = findParent(v);
                if (uParent == vParent) return;
                if (size[uParent] > size[vParent]) {
                    parent[vParent] = uParent;
                    size[uParent] += size[vParent];
                } else {
                    parent[uParent] = vParent;
                    size[vParent] += size[uParent];
                }
            }
        }

        private int[][] getDirectionsFourWays() {
            return new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        }

        private boolean isValid(int i, int j, int n) {
            return i >= 0 && i < n && j >= 0 && j < n;
        }

        public int largestIsland(int[][] grid) {
            int n = grid.length;
            DisjointSet ds = new DisjointSet(n * n);
            int[][] directions = getDirectionsFourWays();

            // Step 1: Union all connected `1`s
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) continue;
                    for (int[] dir : directions) {
                        int newr = i + dir[0];
                        int newc = j + dir[1];
                        if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                            int nodeNo = i * n + j;
                            int adjNodeNo = newr * n + newc;
                            ds.linkNodeBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }

            // Step 2: Calculate maximum island size by flipping a `0`
            int maxIslandSize = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) continue;
                    Set<Integer> uniqueParents = new HashSet<>();
                    for (int[] dir : directions) {
                        int newr = i + dir[0];
                        int newc = j + dir[1];
                        if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                            int parent = ds.findParent(newr * n + newc);
                            uniqueParents.add(parent);
                        }
                    }
                    int currentIslandSize = 1; // Flipping this `0` to `1`
                    for (int parent : uniqueParents) {
                        currentIslandSize += ds.size[parent];
                    }
                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }

            // Step 3: Edge case: If the grid is all `1`s
            for (int i = 0; i < n * n; i++) {
                if (ds.findParent(i) == i) {
                    maxIslandSize = Math.max(maxIslandSize, ds.size[i]);
                }
            }

            return maxIslandSize;
        }
    }

}
