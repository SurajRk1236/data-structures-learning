package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class MinimumNuberGame2974 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] numberGame(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
            int n = nums.length;
            int [] arr = new int[n];
            for(int num : nums){
                pq.offer(num);
            }
            int i = 0;
            while(!pq.isEmpty()){
                int alice = pq.poll();
                int bob = pq.poll();

                arr[i] = bob;
                arr[i + 1] = alice;
                i = i + 2;
            }
            return arr;
        }
    }
}
