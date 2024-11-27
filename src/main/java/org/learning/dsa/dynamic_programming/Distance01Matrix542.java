package org.learning.dsa.dynamic_programming;

import java.util.*;

public class Distance01Matrix542 {
    public static void main(String[] args) {

    }
    class Solution {

        public int[][] updateMatrix(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
            int[][] newmat = new int[n][m];
            Queue<int[]> queue = new LinkedList<>();

            // Initialize all distances to a large value, and add all '0' cells to the queue
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        newmat[i][j] = 0;
                        queue.offer(new int[]{i, j});
                    } else {
                        newmat[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            // Directions for moving up, down, left, and right
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            // Multi-source BFS
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                int dist = newmat[row][col];

                // Explore neighbors
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // Check bounds and if a shorter path is found
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                        if (newmat[newRow][newCol] > dist + 1) {
                            newmat[newRow][newCol] = dist + 1;
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }

            return newmat;
        }
    }
}
