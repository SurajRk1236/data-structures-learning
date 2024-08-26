package org.learning.dsa.arrays;

import java.util.Arrays;

public class SpiralMatrixII59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 0, top = 0, left = 0, right = n - 1, down = n - 1;

        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                start++;
                result[top][i] = start;
            }
            top++;

            for (int i = top; i <= down; i++) {
                start++;
                result[i][right] = start;
            }
            right--;

            if (left <= right) {
                for (int i = right; i >= left; i--) {
                    start++;
                    result[down][i] = start;
                }
                down--;
            }

            if (top <= down) {
                for (int i = down; i >= top; i--) {
                    start++;
                    result[i][left] = start;
                }
                left++;
            }
        }
        return result;

    }
}
