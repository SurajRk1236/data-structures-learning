package org.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetTwo90 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }


    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<>());
        return result;
    }

    private static void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            helper(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
