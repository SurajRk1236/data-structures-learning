package org.learning.dsa.arrays;

public class RemoveElement27 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int counter = val == nums[0] ? 0 : 1;
        for(int i = counter; i < nums.length; i++){
            if(nums[i] != val){
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}
