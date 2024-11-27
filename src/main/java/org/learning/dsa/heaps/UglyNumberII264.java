package org.learning.dsa.heaps;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberII264 {
    public static void main(String[] args) {

    }

    class Solution {
        public int nthUglyNumber(int n) {
            // Min-heap to store the ugly numbers in increasing order
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            Set<Long> seen = new HashSet<>();

            // Add the first ugly number, which is 1
            minHeap.offer(1L);
            seen.add(1L);

            // Possible factors for ugly numbers (2, 3, and 5)
            int[] factors = {2, 3, 5};

            long currentUgly = 1;

            // Generate the next n ugly numbers
            for (int i = 0; i < n; i++) {
                // Get the smallest ugly number
                currentUgly = minHeap.poll();

                // Generate new numbers by multiplying the current number by 2, 3, and 5
                for (int factor : factors) {
                    long newUgly = currentUgly * factor;
                    // Avoid duplicates by using a set
                    if (!seen.contains(newUgly)) {
                        minHeap.offer(newUgly);
                        seen.add(newUgly);
                    }
                }
            }

            // The nth ugly number will be stored in currentUgly
            return (int) currentUgly;
        }
    }
}
