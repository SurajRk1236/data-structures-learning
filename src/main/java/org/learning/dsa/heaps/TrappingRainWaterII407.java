package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class TrappingRainWaterII407 {
    public static void main(String[] args) {

    }


    class Solution {
        // Direction vectors for moving up, down, left, and right
        private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int trapRainWater(int[][] heightMap) {
            // Edge case: if the heightMap is too small, no water can be trapped
            if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
                return 0;
            }

            int m = heightMap.length;
            int n = heightMap[0].length;

            // Priority queue to process cells in increasing order of height
            PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

            // Visited array to keep track of processed cells
            boolean[][] visited = new boolean[m][n];

            // Step 1: Add all the boundary cells to the priority queue
            for (int i = 0; i < m; i++) {
                pq.offer(new Cell(i, 0, heightMap[i][0]));
                pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
                visited[i][0] = true;
                visited[i][n - 1] = true;
            }
            for (int j = 1; j < n - 1; j++) {
                pq.offer(new Cell(0, j, heightMap[0][j]));
                pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
                visited[0][j] = true;
                visited[m - 1][j] = true;
            }

            int waterTrapped = 0;

            // Step 2: Process the cells in the priority queue
            while (!pq.isEmpty()) {
                Cell cell = pq.poll();
                // Check all 4 directions: up, down, left, right
                for (int[] dir : DIRECTIONS) {
                    int newRow = cell.row + dir[0];
                    int newCol = cell.col + dir[1];

                    // If the neighboring cell is within bounds and not yet visited
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;

                        // Calculate water trapped: the difference between the boundary height and the cell height
                        waterTrapped += Math.max(0, cell.height - heightMap[newRow][newCol]);

                        // Add the neighboring cell to the priority queue with an updated height
                        pq.offer(new Cell(newRow, newCol, Math.max(cell.height, heightMap[newRow][newCol])));
                    }
                }
            }

            return waterTrapped;
        }

        // Helper class to represent a cell in the grid
        private static class Cell {
            int row;
            int col;
            int height;

            Cell(int row, int col, int height) {
                this.row = row;
                this.col = col;
                this.height = height;
            }
        }
    }

}
