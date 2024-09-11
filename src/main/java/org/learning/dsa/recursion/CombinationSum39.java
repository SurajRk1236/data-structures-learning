package org.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{2,3,6,7}, 7));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort the candidates to ensure consistent output and to help with optimization
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        // Start the recursive helper function
        helper(0, 0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void helper2(int sum, int index, int[] candidates, int target, List<Integer> temp, List<List<Integer>> result) {
        // Base case: if the current sum matches the target, add the current combination to the result list
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // If the sum exceeds the target, stop further recursion
        if (sum > target) {
            return;
        }

        // Iterate over the candidates starting from the current index
        for (int i = index; i < candidates.length; i++) {
            // Add the current candidate to the temporary list
            temp.add(candidates[i]);
            // Recurse with the updated sum and the same index (since we can reuse the same element)
            helper2(sum + candidates[i], i, candidates, target, temp, result);
            // Backtrack by removing the last added element
            temp.remove(temp.size() - 1);
        }
    }

    private static void helper(int sum, int index, int[] candidates, int target, List<Integer> temp, List<List<Integer>> result) {
        if (target == sum) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < sum) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
//            temp.add(candidates[i]);
//            sum += candidates[i];
//            helper(sum, i, candidates, target, temp, result);
////            helper(sum, i + 1, candidates, target, temp, result);
//            sum -= candidates[i];
//            temp.remove(temp.size() - 1);


            // Add the current candidate to the temporary list
            temp.add(candidates[i]);
            // Recurse with the updated sum and the same index (since we can reuse the same element)
            helper(sum + candidates[i], i, candidates, target, temp, result);
            // Backtrack by removing the last added element
            temp.remove(temp.size() - 1);
        }
    }
}
