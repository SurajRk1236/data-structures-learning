package org.learning.dsa.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PartitionEqualSubSetSum416 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][] dp;
        public int minimumDifference(int[] nums) {
            int total = 0;

            for(int num : nums) total += num;
            checkForPartition(nums, nums.length - 1, total);
            int calculatedResult = 0;
            for(int i = 0; i < total/2; i++){
                if(dp[nums.length - 1][i] == 1){
                    calculatedResult = Math.min(calculatedResult, Math.abs((total - i) - i));
                }
            }
            return calculatedResult;
        }

        private boolean checkForPartition(int[] nums, int index, int target){
            if(target == 0) return true;
            if(index < 0) return false;
            if( dp[index][target] != null) return dp[index][target] == 1;
            boolean notConsider = checkForPartition(nums, index - 1, target);
            boolean consider = false;
            if(target >= nums[index]){
                consider = checkForPartition(nums, index - 1, target - nums[index]);
            }
            dp[index][target] = consider || notConsider ? 1 : 0;
            return consider || notConsider;
        }
    }
}
