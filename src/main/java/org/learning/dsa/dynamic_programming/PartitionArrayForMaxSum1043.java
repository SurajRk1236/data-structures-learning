package org.learning.dsa.dynamic_programming;

public class PartitionArrayForMaxSum1043 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[] dp;
        public int maxSumAfterPartitioning(int[] arr, int k) {
            dp = new Integer[arr.length];
            return getMaxSumAfterPartitioning(0, arr, k);
        }

        private int getMaxSumAfterPartitioning(int i, int[] arr, int k){
            if(i >= arr.length) return 0;
            if(dp[i] != null) return dp[i];
            int max = Integer.MIN_VALUE;
            int largestNum = 0;
            int counter = 0;
            for(int j = i; j < Math.min(i + k, arr.length); j++){
                counter++;
                largestNum = Math.max(arr[j], largestNum);
                int answer = (largestNum * counter) + getMaxSumAfterPartitioning(j + 1, arr, k);
                max = Math.max(answer, max);
            }
            return dp[i] = max;
        }
    }
}
