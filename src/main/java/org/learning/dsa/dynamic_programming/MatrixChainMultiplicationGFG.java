package org.learning.dsa.dynamic_programming;

public class MatrixChainMultiplicationGFG {
    public static void main(String[] args) {
        System.out.println(matrixMultiplication(0, new int[]{40, 20, 30, 10, 30}));
    }

    public static int matrixMultiplication(int N, int arr[]) {
        return getmatrixMultiplication(1, arr.length - 1, arr);
    }

    private static int getmatrixMultiplication(int i, int j, int[] arr) {
        if (i == j) return 0;
        int minMatrix = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            minMatrix = Math.min(minMatrix, (arr[i - 1] * arr[k] * arr[j])
                        + getmatrixMultiplication(i , k, arr) + getmatrixMultiplication(k + 1 , j, arr));
        }
        return minMatrix;
    }
}
