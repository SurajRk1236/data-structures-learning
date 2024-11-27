package org.learning.dsa.greedy;

public class MaximumMatrixSum1975 {
    public static void main(String[] args) {

    }

    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            int n = matrix.length;
            long totalSum = 0;
            int minAbsValue = Integer.MAX_VALUE;
            int negativeCount = 0;

            // Iterate through the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = matrix[i][j];
                    totalSum += Math.abs(value);  // Add the absolute value to the sum
                    if (value < 0) {
                        negativeCount++;  // Count negative numbers
                    }
                    minAbsValue = Math.min(minAbsValue, Math.abs(value));  // Track the smallest absolute value
                }
            }

            // If the count of negatives is odd, subtract twice the smallest absolute value
            if (negativeCount % 2 != 0) {
                totalSum -= 2 * minAbsValue;
            }

            return totalSum;
        }
    }
}
