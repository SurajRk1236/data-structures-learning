package org.learning.dsa.greedy;

public class WiggleSubSequence376 {
    public static void main(String[] args) {

    }

    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length < 2) return nums.length;

            int up = 1;  // Length of longest wiggle sequence ending with a positive difference
            int down = 1;  // Length of longest wiggle sequence ending with a negative difference

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    up = down + 1;
                } else if (nums[i] < nums[i - 1]) {
                    down = up + 1;
                }
            }

            return Math.max(up, down);
        }
    }
}
