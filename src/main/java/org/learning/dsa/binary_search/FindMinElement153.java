package org.learning.dsa.binary_search;

public class FindMinElement153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{11,13,15,17}));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost element, min must be on the
            // right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, min could be the mid element or to the left of mid
                right = mid;
            }
        }

        // After the loop ends, left will point to the minimum element
        return nums[left];
    }
}
