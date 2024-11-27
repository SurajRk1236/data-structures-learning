package org.learning.dsa.dynamic_programming;

public class UniquePathsII63 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][] dp;
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            dp = new Integer[m][n];
            return getUniquePath(m, n, 0, 0, obstacleGrid);
        }

        private int getUniquePath(int m, int n, int down, int right, int[][] obstacleGrid){
            if(m == down || n == right || obstacleGrid[m][n] == 1){
                return 0;
            }
            if(dp[down][right] != null) return dp[down][right];
            if(down == m - 1 && right == n - 1) return 1;

            int downValue = getUniquePath(m, n, down + 1, right, obstacleGrid);
            int rightValue = getUniquePath(m, n, down, right + 1, obstacleGrid);
            dp[down][right] = downValue + rightValue;
            return dp[down][right];
        }
    }
}
