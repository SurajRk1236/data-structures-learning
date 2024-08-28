package org.learning.dsa.arrays;

public class CheckIfArrayIsRotatedAndSorted1752 {
    public static void main(String[] args) {
        System.out.println(check(new int[]{1,2,3}));
    }

    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        return count <= 1;
    }
}
