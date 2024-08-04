package org.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo40 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    private static List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<>(), 0, target);
        return result;
    }

    private static void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> temp, int sum, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            sum += nums[i];
            helper(nums, i + 1, result, temp, sum, target);
            temp.remove(temp.size() - 1);
            sum -= nums[i];
        }
    }
}
