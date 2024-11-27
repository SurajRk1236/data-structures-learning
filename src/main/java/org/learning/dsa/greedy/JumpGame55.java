package org.learning.dsa.greedy;

public class JumpGame55 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean canJump(int[] nums) {
            int maxReach = 0;
            for(int i = 0; i < nums.length; i++){
                if(i > maxReach) return false;
                maxReach = Math.max(maxReach, i + nums[i]);
                if(maxReach > nums.length)return true;
            }
            return true;
        }
    }
}
