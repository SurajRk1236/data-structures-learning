package org.learning.dsa.greedy;

public class ShortestUnsortedContinousSubArray581 {
    public static  void main(String[] args) {

    }

    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int left = -1, right = -1;

            // Find the right boundary of the unsorted subarray
            int maxSeen = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (nums[i] < maxSeen) {
                    right = i;
                } else {
                    maxSeen = nums[i];
                }
            }

            // Find the left boundary of the unsorted subarray
            int minSeen = Integer.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > minSeen) {
                    left = i;
                } else {
                    minSeen = nums[i];
                }
            }

            // If left and right boundaries are unchanged, the array is sorted
            return left == -1 ? 0 : right - left + 1;
        }
    }
}
