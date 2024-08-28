package org.learning.dsa.arrays;

public class RemoveDuplicates26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;  // Initialize the first pointer
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {  // Found a unique element
                i++;  // Move the first pointer
                nums[i] = nums[j];  // Update the array with the unique element
            }
        }
        return i + 1;
    }
}
