package org.learning.dsa.patterns.sliding_window;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement1838 {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{2, 1, 3, 2, 3, 1}, 2));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        long total = 0;
        int maxFrequency = 1;

        while (right < nums.length) {
            total += nums[right];

            // Check if the window is valid
            while ((long) nums[right] * (right - left + 1) > total + k) {
                total -= nums[left];
                left++;
            }

            // Update the max frequency
            maxFrequency = Math.max(maxFrequency, right - left + 1);
            right++;
        }

        return maxFrequency;
    }
}
