package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class TakeGiftFromRichestPile2558 {
    public static void main(String[] args) {

    }

    class Solution {
        public long pickGifts(int[] gifts, int k) {
            // Max heap (Priority Queue that orders largest elements first)
            PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));

            // Insert all gift values into the priority queue
            for (int num : gifts) {
                pq.offer(Long.valueOf(num));
            }

            // Perform k operations where the largest value is reduced to its square root
            while (k > 0) {
                long val = pq.poll();
                pq.offer((long)Math.sqrt(val));
                k--;
            }

            // Sum up the remaining values in the priority queue
            long sum = 0;
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }

            return sum;
        }
    }
}
