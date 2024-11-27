package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class LastStoneWieght1046 {
    public static void main(String[] args) {

    }

    class Solution {
        public int lastStoneWeight(int[] stones) {
            // Max-Heap simulation using a min-heap by inserting negative values
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

            // Insert all stones into the heap (as negative values to simulate max-heap)
            for (int stone : stones) {
                maxHeap.offer(stone);
            }

            // Continue smashing until one or no stones remain
            while (maxHeap.size() > 1) {
                // Extract the two heaviest stones
                int stone1 = maxHeap.poll(); // Heaviest stone
                int stone2 = maxHeap.poll(); // Second heaviest stone

                // If the stones are not of equal weight, insert the difference
                if (stone1 != stone2) {
                    maxHeap.offer(stone1 - stone2);
                }
            }

            // If one stone is left, return its weight; otherwise return 0
            return maxHeap.isEmpty() ? 0 : maxHeap.poll();
        }
    }
}
