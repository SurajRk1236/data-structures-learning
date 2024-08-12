package org.learning.dsa.patterns.two_pointer;

import java.util.Arrays;

public class SortColours75 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColours(new int[]{2, 0, 2, 1, 1, 0})));
    }

    private static int[] sortColours(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int current = 0;

        while (current <= end) {
            if (arr[current] == 0) {
                swap(arr, start, current);
                current++;
                start++;
            } else if (arr[current] == 1) {
                current++;
            } else if (arr[current] == 2) {
                swap(arr, current, end);
                end--;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
