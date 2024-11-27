package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class MinimumAmtTimeFillCups2335 {
    public static void main(String[] args) {

    }

    class Solution {
        public int fillCups(int[] amount) {
            // Create a max-heap (priority queue) to store the amounts in descending order
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

            // Add the non-zero values to the priority queue
            for (int i : amount) {
                if (i > 0) {
                    pq.offer(i);
                }
            }

            int time = 0;

            // While there are at least two types of cups to fill
            while (pq.size() > 1) {
                // Take the two largest values
                int first = pq.poll();
                int second = pq.poll();

                // Fill both types simultaneously, reducing both by 1
                first--;
                second--;

                // Increment time since we used 1 second
                time++;

                // If any cups are still left to fill, push them back into the priority queue
                if (first > 0) {
                    pq.offer(first);
                }
                if (second > 0) {
                    pq.offer(second);
                }
            }

            // If there's one type of cup left, fill it one cup at a time
            if (!pq.isEmpty()) {
                time += pq.poll();
            }

            return time;
        }
    }
}
