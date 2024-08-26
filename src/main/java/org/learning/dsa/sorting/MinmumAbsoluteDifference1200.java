package org.learning.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinmumAbsoluteDifference1200 {
    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);  // Step 1: Sort the array

        int minDiff = Integer.MAX_VALUE;

        // Step 2: Find the minimum difference
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(minDiff, diff);
        }

        // Step 3: Collect pairs with the minimum difference
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
