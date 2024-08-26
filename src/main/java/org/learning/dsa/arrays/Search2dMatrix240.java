package org.learning.dsa.arrays;

public class Search2dMatrix240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(searchMatrix(matrix, 9));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, rowEnd = matrix.length - 1, col =  matrix[0].length - 1;
        while (row <= rowEnd && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
