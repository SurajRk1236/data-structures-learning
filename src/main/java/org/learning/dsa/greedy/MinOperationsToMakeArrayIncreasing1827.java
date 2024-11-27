package org.learning.dsa.greedy;

public class MinOperationsToMakeArrayIncreasing1827 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minOperations(int[] nums) {
            int operations = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] <= nums[i - 1]) {
                    int increment = nums[i - 1] - nums[i] + 1;
                    nums[i] += increment;
                    operations += increment;
                }
            }

            return operations;
        }
    }
}
