package org.learning.dsa.dynamic_programming;

public class UniquePath62 {
    public static void main(String[] args) {

    }

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] memo = new int[m][n]; // Memoization array
            return getUniquePathCount(m, n, 0, 0, memo);
        }

        private int getUniquePathCount(int m, int n, int down, int right, int[][] memo) {
            // If out of bounds, return 0 as there's no valid path
            if (down >= m || right >= n) {
                return 0;
            }

            // If we reached the bottom-right corner, there's exactly one path
            if (down == m - 1 && right == n - 1) {
                return 1;
            }

            // If already computed, use the memoized result
            if (memo[down][right] != 0) {
                return memo[down][right];
            }

            // Calculate paths by going right and down
            int rightPaths = getUniquePathCount(m, n, down, right + 1, memo);
            int downPaths = getUniquePathCount(m, n, down + 1, right, memo);

            // Memoize and return the result for the current cell
            memo[down][right] = rightPaths + downPaths;
            return memo[down][right];
        }
    }
}
