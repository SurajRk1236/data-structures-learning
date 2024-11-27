package org.learning.dsa.dynamic_programming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence673 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int[] count = new int[n];
            Arrays.fill(dp, 1);
            Arrays.fill(count, 1);
            int maxlength = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && 1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];
                    }else if(nums[i] > nums[j] && 1 + dp[j] == dp[i]){
                        count[i] += count[j];
                    }
                }
                maxlength = Math.max(dp[i], maxlength);
            }

            int answer = 0;
            for(int i = 0; i < n; i++){
                if(dp[i] == maxlength){
                    answer += count[i];
                }
            }
            return answer;
        }

    }
}
