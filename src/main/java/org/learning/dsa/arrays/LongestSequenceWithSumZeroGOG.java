package org.learning.dsa.arrays;

import java.util.HashMap;

public class LongestSequenceWithSumZeroGOG {
    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    public static int maxLen(int[] nums) {
        // HashMap to store (sum, index) pairs
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max_len = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) {
                max_len = i + 1;
            } else if (map.containsKey(sum)) {
                max_len = Math.max(max_len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return max_len;
    }
}
