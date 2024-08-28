package org.learning.dsa.binary_search;

public class FindNumberOfTimesRotatedGFG {
    public static void main(String[] args) {
        System.out.println(findNumberOfTimesRotated(new int[]{3,4,5,1,2}));
    }

    public static int findNumberOfTimesRotated(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else
                right = mid;
        }
        return left;
    }
}
