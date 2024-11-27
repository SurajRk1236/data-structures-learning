package org.learning.dsa.dynamic_programming;

public class LongestIncreasingSubSequence300 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][] dp;
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            dp = new Integer[n][n + 1];
            return getMaxLengthOfLis(0, -1, nums);
        }

        private int getMaxLengthOfLis(int i, int j, int[] nums){
            if(i >= nums.length) return 0;
            if(dp[i][j + 1]  != null) return dp[i][j + 1];
            int len = getMaxLengthOfLis(i + 1, j, nums);
            if(j == -1 || nums[j] < nums[i]){
                len = Math.max(len,  1 + getMaxLengthOfLis(i + 1, i, nums));
            }
            return dp[i][j + 1] = len;
        }
    }
}
