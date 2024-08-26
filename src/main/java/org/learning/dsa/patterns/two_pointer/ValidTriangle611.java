package org.learning.dsa.patterns.two_pointer;

import java.util.Arrays;

public class ValidTriangle611 {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{4,2,3,4}));
    }

    private static int triangleNumber(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        int count = 0;

        // Start from the end of the array
        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0, j = k - 1;

            // Two pointers technique
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i;  // All pairs (i, j), (i+1, j), ..., (j-1, j) are valid
                    j--;  // Move j to the left
                } else {
                    i++;  // Move i to the right
                }
            }
        }

        return count;
    }
}
