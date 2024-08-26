package org.learning.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        // Initialize a list to store the result of the spiral order
        List<Integer> result = new ArrayList<>();

        // If the matrix is empty, return the empty result list
        if (matrix == null || matrix.length == 0) return result;

        // Define the initial boundaries of the matrix
        int top = 0;                        // Top boundary
        int bottom = matrix.length - 1;     // Bottom boundary
        int left = 0;                       // Left boundary
        int right = matrix[0].length - 1;   // Right boundary

        // Continue looping while the boundaries do not overlap
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // Move the top boundary down
            top++;

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // Move the right boundary to the left
            right--;

            // Check if the top and bottom boundaries have crossed
            if (top <= bottom) {
                // Traverse from right to left along the bottom boundary
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                // Move the bottom boundary up
                bottom--;
            }

            // Check if the left and right boundaries have crossed
            if (left <= right) {
                // Traverse from bottom to top along the left boundary
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                // Move the left boundary to the right
                left++;
            }
        }

        // Return the list containing the matrix elements in spiral order
        return result;    }
}
