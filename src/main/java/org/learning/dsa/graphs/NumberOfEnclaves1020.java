package org.learning.dsa.graphs;

public class NumberOfEnclaves1020 {
    public static void main(String[] args) {

    }

    class Solution {
        public int numEnclaves(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int answer = 0, landCell = 1;
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < m; i++) {
                if (grid[0][i] == landCell && !visited[0][i]) {
                    bfs(0, i, n, m, grid, visited);
                }
                if (grid[n - 1][i] == landCell && !visited[n - 1][i]) {
                    bfs(n-1 , i, n, m, grid, visited);
                }
            }

            for (int i = 0; i < n; i++) {
                if (grid[i][0] == landCell && !visited[i][0]) {
                    bfs(i, 0, n, m, grid, visited);
                }
                if (grid[i][m - 1] == landCell && !visited[i][m - 1]) {
                    bfs(i, m - 1, n, m, grid, visited);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && grid[i][j] == landCell) {
                        answer++;
                    }
                }
            }
            return answer;
        }

        private void bfs(int i, int j, int n, int m, int[][] grid, boolean[][] visited) {
            visited[i][j] = true;
            int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (canVisitNextNode(row, col, n, m, grid, visited)) {
                    bfs(row, col, n, m, grid, visited);
                }
            }
        }

        private boolean canVisitNextNode(int row, int col, int n, int m, int[][] grid, boolean[][] visited) {
            int land = 1;
            return row >= 0 && row < n && col >= 0 && col < m && !visited[row][col] && grid[row][col] == land;
        }
    }
}
