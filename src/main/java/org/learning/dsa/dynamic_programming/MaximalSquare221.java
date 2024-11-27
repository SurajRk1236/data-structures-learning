package org.learning.dsa.dynamic_programming;

public class MaximalSquare221 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][] dp;
        public int maximalSquare(char[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            dp = new Integer[n][m];
            int maxArea = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(matrix[i][j] == '1'){
                        int side = getMaxSquareArea(i, j, n, m, matrix);
                        maxArea = Math.max(maxArea, side * side);
                    }
                }
            }
            return maxArea;
        }

        private int getMaxSquareArea(int i, int j, int n, int m, char[][] matrix){
            if(i >= n || j >= m || matrix[i][j] == '0') return 0;
            if(dp[i][j] != null) return dp[i][j];
            int down = getMaxSquareArea(i + 1, j, n, m, matrix);
            int diagnol = getMaxSquareArea(i + 1, j + 1, n, m, matrix);
            int right = getMaxSquareArea(i, j + 1, n, m, matrix);
            int area = 1 + Math.min(down, Math.min(diagnol, right));
            return dp[i][j] = area;
        }
    }
}
