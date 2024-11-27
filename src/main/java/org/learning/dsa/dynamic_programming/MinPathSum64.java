package org.learning.dsa.dynamic_programming;

public class MinPathSum64 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][] dp;

        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            dp = new Integer[m][n];
            return getMinPath(m, n, 0, 0, grid);
        }

        private int getMinPath(int m, int n, int down, int right, int[][] grid) {
            // Base Case: If out of bounds, return a large value to avoid this path
            if (down >= m || right >= n) {
                return Integer.MAX_VALUE;
            }

            // Base Case: When reaching the bottom-right cell
            if (down == m - 1 && right == n - 1) {
                return grid[down][right];
            }

            // If the value has been computed before, return it
            if (dp[down][right] != null) {
                return dp[down][right];
            }

            // Calculate minimum path by moving down and right
            int downPath = getMinPath(m, n, down + 1, right, grid);
            int rightPath = getMinPath(m, n, down, right + 1, grid);

            // Store the result of the minimum path sum for current cell
            dp[down][right] = grid[down][right] + Math.min(downPath, rightPath);
            return dp[down][right];
        }
    }
}
