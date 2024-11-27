package org.learning.dsa.recursion;

import java.util.*;

public class PermutationII47 {
    public static void main(String[] args) {

    }
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums); // Sort to make duplicate handling easier
            List<List<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            backtrack(nums, new ArrayList<>(), visited, result);
            return result;
        }

        private void backtrack(int[] nums, List<Integer> current, boolean[] visited, List<List<Integer>> result) {
            if (current.size() == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // Skip visited elements or duplicates in the same depth
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                    continue;
                }

                visited[i] = true;
                current.add(nums[i]);

                backtrack(nums, current, visited, result);

                // Backtrack
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

}
