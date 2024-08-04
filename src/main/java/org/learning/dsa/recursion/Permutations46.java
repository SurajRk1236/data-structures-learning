package org.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        bactrack(nums, 0, result);
        return result;
    }

    private static void bactrack(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> ans = new ArrayList<>();
            for (int num : nums) {
                ans.add(num);
            }
            result.add(ans);
        }
        for (int j = i; j < nums.length; j++) {
            swap(i, j, nums);
            bactrack(nums, i + 1, result);
            swap(i, j, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
