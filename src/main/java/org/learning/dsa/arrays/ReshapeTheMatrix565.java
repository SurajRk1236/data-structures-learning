package org.learning.dsa.arrays;

public class ReshapeTheMatrix565 {
    public static void main(String[] args) {

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        // Get the original number of rows and columns in the matrix
        int originalRows = mat.length;
        int originalCols = mat[0].length;

        // Check if reshaping is possible with the given dimensions
        if (originalRows * originalCols != r * c) {
            return mat; // If not, return the original matrix
        }

        // Initialize the reshaped matrix with the new dimensions
        int[][] reshapedMatrix = new int[r][c];

        // Use a single loop to go through every element in the original matrix
        for (int i = 0; i < originalRows * originalCols; i++) {
            // Calculate the position in the new matrix
            reshapedMatrix[i / c][i % c] = mat[i / originalCols][i % originalCols];
        }

        // Return the newly reshaped matrix
        return reshapedMatrix;
    }

}
