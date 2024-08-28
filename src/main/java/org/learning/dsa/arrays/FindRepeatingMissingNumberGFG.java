package org.learning.dsa.arrays;

import java.util.Arrays;

public class FindRepeatingMissingNumberGFG {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRepeatingMissingNumber(new int[]{1, 2, 4, 4}, 4)));
    }

    public static int[] findRepeatingMissingNumber(int[] arr, int n) {
        int sumN = n * (n + 1) / 2;
        int sumNSquare = n * (n + 1) * (2 * n + 1) / 6;
        int sum = 0;
        int sumSquare = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            sumSquare += arr[i] * arr[i];
        }

        int diff = sumN - sum; // A - B
        int sumDiff = (sumNSquare - sumSquare) / diff; // A + B

        int missing = (diff + sumDiff) / 2;
        int repeated = sumDiff - missing;

        return new int[]{repeated, missing};
    }
}
