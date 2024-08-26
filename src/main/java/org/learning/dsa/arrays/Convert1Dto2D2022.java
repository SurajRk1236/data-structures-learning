package org.learning.dsa.arrays;

import java.util.Arrays;

public class Convert1Dto2D2022 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2, 3}, 1, 3)));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0]; // Return an empty 2D array if the sizes don't match
        }
        int start = 0;
        int[][] newArray = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newArray[i][j] = original[start];
                start++;
            }
        }
        return newArray;
    }
}
