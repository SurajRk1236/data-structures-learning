package org.learning.dsa;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] matrix = {{5}};
        System.out.println(diagonalSum(matrix));

    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];
        }

        if (n % 2 != 0)
            sum -= mat[n / 2][n / 2];
        return sum;
    }
}
