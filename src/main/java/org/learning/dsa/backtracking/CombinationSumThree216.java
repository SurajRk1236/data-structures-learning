package org.learning.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<>(), 0, n, k);
        return result;
    }

    private static void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> temp, int sum, int target, int k) {
        if (sum == target && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target || temp.size() == k) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            sum += nums[i];
            helper(nums, i + 1, result, temp, sum, target, k);
            temp.remove(temp.size() - 1);
            sum -= nums[i];
        }
    }
}
