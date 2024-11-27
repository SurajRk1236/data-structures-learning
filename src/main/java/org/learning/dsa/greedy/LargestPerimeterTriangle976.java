package org.learning.dsa.greedy;

import java.util.Arrays;

public class LargestPerimeterTriangle976 {
    public static void main(String[] args) {

    }

    class Solution {
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums); // Sort in ascending order
            // Start from the largest elements and check if they can form a triangle
            for (int i = nums.length - 1; i >= 2; i--) {
                if (nums[i - 2] + nums[i - 1] > nums[i]) {
                    // Return the perimeter if a valid triangle is found
                    return nums[i - 2] + nums[i - 1] + nums[i];
                }
            }
            // No valid triangle found
            return 0;
        }
    }
}
