package org.learning.dsa.dynamic_programming;

public class HouseRobberII213 {
    public static void main(String[] args) {

    }

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            if (n == 0) return 0;

            // Memoization arrays for the two cases
            Integer[] dp1 = new Integer[n];
            Integer[] dp2 = new Integer[n];

            // Calculate the max rob amount for two cases
            int robFirst = robRange(nums, 0, n - 2, dp1);  // Rob houses from 0 to n-2
            int robLast = robRange(nums, 1, n - 1, dp2);    // Rob houses from 1 to n-1

            return Math.max(robFirst, robLast);  // Take the maximum of the two cases
        }

        private int robRange(int[] nums, int start, int end, Integer[] dp) {
            if (start > end) return 0;
            if (dp[start] != null) return dp[start];

            // Decide to rob the current house or skip it
            int robCurrent = nums[start] + robRange(nums, start + 2, end, dp);
            int skipCurrent = robRange(nums, start + 1, end, dp);

            dp[start] = Math.max(robCurrent, skipCurrent);  // Memoize result
            return dp[start];
        }
    }
}
