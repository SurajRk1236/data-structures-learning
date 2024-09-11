package org.learning.dsa.binary_search;

import java.util.Arrays;

public class FindPeakElementII2dMat1901 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPeakGrid(new int[][]{{1, 4}, {3, 2}})));
    }

    public static int[] findPeakGrid(int[][] mat) {
        int left = 0;
        int right = mat[0].length - 1;
        int[] result = new int[2];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int maxRow = getMaxColValue(mid, mat);

            // Corrected comparison for neighbors
            boolean isPeak = (mid == 0 || mat[maxRow][mid] > mat[maxRow][mid - 1]) &&
                    (mid == mat[0].length - 1 || mat[maxRow][mid] > mat[maxRow][mid + 1]);

            if (isPeak) {
                result[0] = maxRow;
                result[1] = mid;
                return result;
            } else if (mid < mat[0].length - 1 && mat[maxRow][mid] < mat[maxRow][mid + 1]) {
                left = mid + 1;  // Move right
            } else {
                right = mid - 1; // Move left
            }
        }

        result[0] = -1;
        result[1] = -1;
        return result;
    }

    // Method to get the row index of the maximum element in the specified column
    private static int getMaxColValue(int mid, int[][] mat) {
        int maxRow = 0;
        for (int i = 1; i < mat.length; i++) {  // Fix to include the last row
            if (mat[i][mid] > mat[maxRow][mid]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
}
