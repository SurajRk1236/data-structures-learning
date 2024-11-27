package org.learning.dsa.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PartitionArrayIntoTwoArraysMinSum2035 {
    public static void main(String[] args) {

    }

    class Solution {
        int value = 0;
        public int minimumDifference(int[] nums) {
            int total = 0;
            for(int num : nums) total += num;
            List<Integer> result = new ArrayList<>();
            getAbsoluteValue(nums, nums.length - 1, total/2, result);
            int calculatedResult = 0;
            for(Integer num : result) calculatedResult += num;
            return total - calculatedResult;
        }

        private boolean getAbsoluteValue(int[] nums, int index, int target,List<Integer> tempList){
            if(target<=0)return true;
            if(index<0) return false;
            boolean take = false;
            boolean untake = false;
            if(nums[index] < target) {
                tempList.add(nums[index]);
                take = getAbsoluteValue(nums, index - 1, target - nums[index],tempList);
            }
            if(!take){
                tempList.remove(tempList.size() - 1);
                untake = getAbsoluteValue(nums, index - 1, target, tempList);
            }
            return take || untake;
        }
    }
}
