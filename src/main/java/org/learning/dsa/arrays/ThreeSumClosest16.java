package org.learning.dsa.arrays;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < 3;i++){
            sum += nums[i];
        }

        for(int i = 0; i < nums.length - 2;i++){
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int closest = nums[i] + nums[left] + nums[right];

                if(Math.abs(sum - target) > Math.abs(closest - target)){
                    sum = closest;
                }

                if (closest < target) {
                    left++;
                } else if (closest > target) {
                    right--;
                } else {
                    return closest;
                }
            }
        }

        return sum;
    }
}
