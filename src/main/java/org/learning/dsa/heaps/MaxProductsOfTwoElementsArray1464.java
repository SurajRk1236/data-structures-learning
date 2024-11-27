package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class MaxProductsOfTwoElementsArray1464 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxProduct(int[] nums) {
            // Max-heap to get the two largest numbers
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

            // Add all elements to the max-heap
            for (int num : nums) {
                pq.offer(num);
            }

            // Extract the two largest numbers
            int firstMax = pq.poll();  // Largest element
            int secondMax = pq.poll(); // Second largest element

            // Return the product after subtracting 1 from both numbers
            return (firstMax - 1) * (secondMax - 1);
        }
    }
}
