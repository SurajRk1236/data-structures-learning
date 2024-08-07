package org.learning.dsa.backtracking;

public class TargetSum294 {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        count = 0;
        helper(nums, 0, 0, target);
        return count;
    }

    private static void helper(int[] nums, int index, int sum, int target) {
        if (nums.length == index) {
            if (sum == target) {
                count++;
            }
            return;
        }
        helper(nums, index + 1, sum + nums[index], target);
        helper(nums, index + 1, sum - nums[index], target);
    }
}
