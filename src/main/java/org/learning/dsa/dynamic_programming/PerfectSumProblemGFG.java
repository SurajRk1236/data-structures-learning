package org.learning.dsa.dynamic_programming;

public class PerfectSumProblemGFG {
    public static void main(String[] args) {

    }

    class Solution {
        public int perfectSum(int[] arr, int target) {
            int n = arr.length;
            Integer[][] dp = new Integer[n][target + 1];
            return countSubsets(arr, target, n - 1, dp);
        }

        private int countSubsets(int[] arr, int target, int index, Integer[][] dp) {
            // Base cases
            if (target == 0) return 1; // One way to reach sum 0: choose no elements
            if (index < 0) return 0;    // No ways to reach target if no elements are left

            // Return the precomputed result if available
            if (dp[index][target] != null) return dp[index][target];

            // Calculate the result by excluding the current element
            int exclude = countSubsets(arr, target, index - 1, dp);

            // Calculate the result by including the current element, if it's <= target
            int include = 0;
            if (arr[index] <= target) {
                include = countSubsets(arr, target - arr[index], index - 1, dp);
            }

            // Memoize and return the result
            dp[index][target] = include + exclude;
            return dp[index][target];
        }
    }

}
