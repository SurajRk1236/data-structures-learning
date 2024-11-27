package org.learning.dsa.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToHalf1338 {
    public static void main(String[] args) {

    }
    class Solution {
        public int minSetSize(int[] arr) {
            // Step 1: Count the frequency of each element
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : arr) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // Step 2: Create a max-heap (priority queue) for frequencies
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int freq : freqMap.values()) {
                pq.offer(freq);
            }

            // Step 3: Keep removing elements with the highest frequencies
            int totalRemoved = 0;
            int distinctElements = 0;
            int targetSize = arr.length / 2;

            while (totalRemoved < targetSize) {
                totalRemoved += pq.poll();
                distinctElements++;
            }

            // Step 4: Return the number of distinct elements removed
            return distinctElements;
        }
    }
}
