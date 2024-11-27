package org.learning.dsa.dynamic_programming;

public class MinimumFallingPathSum931 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][] dp;
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            dp = new Integer[n][n];
            int result = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                result = Math.min(result, getFallingPathSum(n, i, 0, matrix));
            }
            return result;
        }

        private int getFallingPathSum(int n, int col, int row, int[][] matrix){
            if(col >= n || row>= n || col < 0 || row < 0){
                return Integer.MAX_VALUE;
            }
            if(row == n - 1){
                return matrix[row][col];
            }

            if(dp[row][col] != null) return dp[row][col];
            int left = getFallingPathSum(n, col - 1, row + 1, matrix);
            int right = getFallingPathSum(n, col + 1, row + 1, matrix);
            int down = getFallingPathSum(n, col, row + 1, matrix);
            dp[row][col] = matrix[row][col] + Math.min(left, Math.min(down, right));
            return dp[row][col];
        }
    }
}
