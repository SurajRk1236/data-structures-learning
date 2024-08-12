package org.learning.dsa.patterns.two_pointer;

public class MoveAllZeroesToRight283 {

    public static void main(String[] args) {
        System.out.println(moveZeroes(new int[]{0, 1, 0, 3, 12}));
    }

    public static int[] moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        return nums;
    }
}
