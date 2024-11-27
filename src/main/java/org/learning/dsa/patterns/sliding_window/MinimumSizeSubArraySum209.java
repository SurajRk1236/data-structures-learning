package org.learning.dsa.patterns.sliding_window;

public class MinimumSizeSubArraySum209 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int sum = 0; // Current window sum
            int ans = Integer.MAX_VALUE; // Initialize with maximum value
            int i = 0; // Start of the window

            for (int j = 0; j < n; j++) {
                sum += nums[j]; // Expand the window by adding nums[j]

                // Shrink the window while the sum is greater than or equal to the target
                while (sum >= target) {
                    ans = Math.min(ans, j - i + 1); // Update minimum length
                    sum -= nums[i]; // Shrink the window from the left
                    i++; // Move the start pointer
                }
            }

            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
