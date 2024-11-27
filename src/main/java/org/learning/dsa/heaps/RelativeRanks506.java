package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class RelativeRanks506 {
    public static void main(String[] args) {

    }

    class Solution {
        public String[] findRelativeRanks(int[] score) {
            // Step 1: Create a max heap by using a custom comparator
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

            // Step 2: Insert all the scores with their indices into the priority queue
            for (int i = 0; i < score.length; i++) {
                pq.offer(new int[]{score[i], i});
            }

            // Step 3: Prepare an array to store the results (ranks)
            String[] result = new String[score.length];

            // Step 4: Initialize rank for extracting elements
            int rank = 1;

            // Step 5: Extract elements from the priority queue and assign ranks
            while (!pq.isEmpty()) {
                int[] top = pq.poll();
                int index = top[1]; // Get the original index

                // Assign ranks based on the value of 'rank'
                if (rank == 1) {
                    result[index] = "Gold Medal";
                } else if (rank == 2) {
                    result[index] = "Silver Medal";
                } else if (rank == 3) {
                    result[index] = "Bronze Medal";
                } else {
                    result[index] = String.valueOf(rank);
                }

                rank++;
            }

            return result;

        }
    }
}
