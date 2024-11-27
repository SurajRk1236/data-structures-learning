package org.learning.dsa.dynamic_programming;

import java.util.Arrays;

public class HouseRobber198 {
    public static void main(String[] args) {

    }

    class Solution {
        int[] dp;
        public int rob(int[] nums) {
            dp = new int[nums.length];
            Arrays.fill(dp, -1);
            return getMaxAmount(nums.length - 1, nums);
        }

        private int getMaxAmount(int i, int[] nums){
            if(i == 0) return nums[i];
            if(i < 0) return 0;
            if(dp[i] != -1) return dp[i];
            int alternate = nums[i] + getMaxAmount(i - 2, nums);
            int alternateNotCal = getMaxAmount(i - 1, nums);
            dp[i] = Math.max(alternate, alternateNotCal);
            return dp[i];
        }
    }
}
