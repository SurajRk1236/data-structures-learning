package org.learning.dsa.arrays;

import java.util.Arrays;

public class RotateAnArray189 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotateArray(nums, 0, n - 1);
        rotateArray(nums, 0, k - 1);
        rotateArray(nums, k, n - 1);
    }

    private static void rotateArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
