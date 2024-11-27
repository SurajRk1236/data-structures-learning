package org.learning.dsa.dynamic_programming;

import java.util.Arrays;

public class BurstBallons312 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][] dp;
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] nums2 = new int[n + 2];
            nums2[0] = 1;
            nums2[nums2.length - 1] = 1;
            for(int i = 0; i < n; i++){
                nums2[i + 1] = nums[i];
            }
            dp = new Integer[n + 2][n + 2];
            System.out.println(Arrays.toString(nums2));
            return getMaxCoins(1, n, nums2);
        }

        private int getMaxCoins(int i, int n, int[] nums){
            if(i > n) return 0;
            if(dp[i][n] != null) return dp[i][n];
            int max = Integer.MIN_VALUE;
            for(int k = i; k <= n; k++){
                int answer = nums[i - 1] * nums[k] * nums[n + 1] +
                        getMaxCoins(i, k - 1, nums) +
                        getMaxCoins(k + 1, n, nums);
                max = Math.max(max, answer);
            }
            return dp[i][n] = max;
        }
    }
}
