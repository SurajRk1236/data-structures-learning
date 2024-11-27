package org.learning.dsa.dynamic_programming;

public class SplitArrayIntoTwoParts805 {

    class Solution {
        public boolean solve(int ind, int targetSum, int targetCnt, int[] nums, Boolean[][][] dp) {
            if (targetSum == 0 && targetCnt == 0) return true;
            if (targetSum < 0 || targetCnt < 0 || ind >= nums.length) return false;
            if (dp[ind][targetCnt][targetSum] != null) return dp[ind][targetCnt][targetSum];

            // Take current element
            boolean ans = solve(ind + 1, targetSum - nums[ind], targetCnt - 1, nums, dp);
            if (ans) return true;

            // Skip current element
            ans = solve(ind + 1, targetSum, targetCnt, nums, dp);

            return dp[ind][targetCnt][targetSum] = ans;
        }

        public boolean splitArraySameAverage(int[] nums) {
            int totalSum = 0;
            int n = nums.length;

            for (int num : nums) totalSum += num;

            // DP array, with dp[index][count][sum] as the state
            Boolean[][][] dp = new Boolean[n + 1][n + 1][totalSum + 1];

            for (int i = 1; i < n; i++) {
                if ((i * totalSum) % n == 0 && solve(0, (i * totalSum) / n, i, nums, dp)) {
                    return true;
                }
            }
            return false;
        }
    }

}
