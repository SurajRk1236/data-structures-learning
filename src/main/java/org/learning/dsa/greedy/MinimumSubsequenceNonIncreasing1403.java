package org.learning.dsa.greedy;
import java.util.*;
public class MinimumSubsequenceNonIncreasing1403 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            Arrays.sort(nums);
            List<Integer> result = new ArrayList<>();

            int totalSum = 0;
            for (int num : nums) totalSum += num;

            int subsequenceSum = 0;

            // Iterate from the largest to the smallest element
            for (int i = nums.length - 1; i >= 0; i--) {
                subsequenceSum += nums[i];
                result.add(nums[i]);

                // Stop when the subsequence sum is greater than the remaining sum
                if (subsequenceSum > totalSum - subsequenceSum) {
                    break;
                }
            }

            return result;
        }
    }
}
