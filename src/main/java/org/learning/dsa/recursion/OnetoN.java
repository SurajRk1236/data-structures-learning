package org.learning.dsa.recursion;

import java.util.Arrays;

public class OnetoN {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(2)));
    }

    private static int[] solve(int n) {

        int[] newValues = new int[n];
        if (n == 0) {
            return newValues;
        }
        int index = n - 1;
        return getValuesForN(n, newValues, index);
    }

    private static int[] getValuesForN(int n, int[] newValues, int index) {
        newValues[index] = n;
        if (n == 1) {
            return newValues;
        }
        return getValuesForN(n - 1, newValues, index - 1);
    }
}
