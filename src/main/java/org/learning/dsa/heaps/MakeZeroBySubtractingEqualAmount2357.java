package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class MakeZeroBySubtractingEqualAmount2357 {
    public static void main(String[] args) {

    }

    class Solution {
        PriorityQueue<Integer> pq;
        public int minimumOperations(int[] nums) {
            int timeRequired = 0;
            initializePriorityQueue();
            insertValuesToPq(nums);
            while(!pq.isEmpty()){
                int minNum = pq.poll();
                alterValuesArray(minNum, nums);
                initializePriorityQueue();
                insertValuesToPq(nums);
                timeRequired ++;
            }
            return timeRequired;
        }

        private void alterValuesArray(int min, int[] nums){
            for(int i = 0; i < nums.length; i++){
                nums[i] = nums[i] - min;
            }
        }

        private void insertValuesToPq(int[] nums){
            for(int num : nums){
                if(num > 0)
                    pq.offer(num);
            }
        }

        private void initializePriorityQueue(){
            pq = new PriorityQueue<>((a, b) -> a - b);
        }
    }
}
