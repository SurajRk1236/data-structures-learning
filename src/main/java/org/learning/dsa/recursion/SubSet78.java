package org.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSet78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 2}));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, nums, 0, new ArrayList<>());
        return result;
    }

    private static void backTrack(List<List<Integer>> result, int[] nums, int index, List<Integer> tempList) {
        result.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(result, nums, i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
