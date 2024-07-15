package org.learning.dsa.arrays;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
    }

    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        int previousValue = 0;
        for (int i = 0; i < length; i++){
            nums[i] = nums[i] + previousValue;
            previousValue = nums[i];
        }
        return nums;
    }
}
