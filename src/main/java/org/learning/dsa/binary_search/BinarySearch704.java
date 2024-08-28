package org.learning.dsa.binary_search;

public class BinarySearch704 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
