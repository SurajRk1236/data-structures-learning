package org.learning.dsa.greedy;

import java.util.Arrays;

public class ArrayPartition561 {
    public static void main(String[] args) {

    }

    class Solution {
        public int arrayPairSum(int[] nums) {
            // Sort the array to easily access pairs
            Arrays.sort(nums);

            int sum = 0;
            // Sum up every second element starting from index 0
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }

            return sum;
        }
    }
}
