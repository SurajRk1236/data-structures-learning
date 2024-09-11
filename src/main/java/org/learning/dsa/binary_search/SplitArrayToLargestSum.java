package org.learning.dsa.binary_search;

public class SplitArrayToLargestSum {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1,2,3,4,5},2));
    }

    public static int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }

        while(left < right){
            int mid = left + (right - left)/2;
            if(condition(mid, nums, k)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean condition(int mid, int[] nums, int k){
        int count = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(sum > mid){
                count ++;
                sum = num;
            }
        }

        return count < k;
    }
}
