package org.learning.dsa.patterns.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairsWithSmallestSum373 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        int[] arr2 = new int[]{1,2,3};
        int target = 2;
        System.out.println(kSmallestPairs(arr, arr2, target));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Iterate through the first array
        for (int i = 0; i < nums1.length && result.size() < k; i++) {
            // Pair with elements from the second array
            for (int j = 0; j < nums2.length && result.size() < k; j++) {
                result.add(Arrays.asList(nums1[i], nums2[j]));
            }
        }

        // Sort based on the sum to ensure we have the smallest k pairs
        result.sort((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));

        // If we have more than k pairs, trim the list
        return result.subList(0, Math.min(k, result.size()));
    }

}
