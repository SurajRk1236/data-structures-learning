package org.learning.dsa.hashing;

import java.util.Arrays;

public class MaxSubSequence2099 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{-1,-2,3,4}, 3)));
    }
    public static int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        if(length <= k)
            return nums;
        int start = 0,sum=0,l=0;
        for (int i=0 ;i < k;i++){
            sum += nums[i];
        }

        for(int i = k ; i< length; i++){
            int counterSum = sum - nums[start] + nums[i];
            if(sum < counterSum){
                sum = counterSum;
                l = start + 1;
            }
            start++;
        }
        int [] data = new int[k];
        for(int i=0 ;i < k ;i++){
            data[i] = nums[l];
            l++;
        }
        return data;
    }
}
