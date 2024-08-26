package org.learning.dsa.arrays;


/**
 * this is based on how to give the area for particular sum in an range
 * first we will take the prefix sum
 * and then
 * while giving the data we check for overlap cae
 */


public class RangeSumQuery2d304 {
    public static void main(String[] args) {

    }

    static class NumMatrix {
        private int[][] sumMatrix;
        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            int m = matrix.length;
            int n = matrix[0].length;
            sumMatrix = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sumMatrix[i][j] = matrix[i - 1][j - 1]
                            + sumMatrix[i - 1][j]
                            + sumMatrix[i][j - 1]
                            - sumMatrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1++;
            col1++;
            row2++;
            col2++;
            return sumMatrix[row2][col2]
                    - sumMatrix[row1 - 1][col2]
                    - sumMatrix[row2][col1 - 1]
                    + sumMatrix[row1 - 1][col1 - 1];
        }
    }
}
