package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class LongestHappyString1405 {
    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            // Max heap to always get the character with the highest frequency
            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);

            // Insert the available characters with their counts into the heap
            if (a > 0) pq.offer(new int[]{'a', a});
            if (b > 0) pq.offer(new int[]{'b', b});
            if (c > 0) pq.offer(new int[]{'c', c});

            StringBuilder result = new StringBuilder();

            while (!pq.isEmpty()) {
                int[] first = pq.poll(); // Get the character with the highest count
                int len = result.length();

                // Check if adding this character will cause three consecutive same characters
                if (len >= 2 && result.charAt(len - 1) == first[0] && result.charAt(len - 2) == first[0]) {
                    if (pq.isEmpty()) {
                        break; // No other character to use, so we can't proceed
                    }

                    // Get the second most frequent character
                    int[] second = pq.poll();
                    result.append((char) second[0]);
                    second[1]--;

                    // Reinsert second character back if it still has remaining count
                    if (second[1] > 0) {
                        pq.offer(second);
                    }

                    // Also put the first character back since we couldn't use it in this step
                    pq.offer(first);
                } else {
                    // If adding this character doesn't cause three consecutive, append it
                    result.append((char) first[0]);
                    first[1]--;

                    // Reinsert the character back if it still has remaining count
                    if (first[1] > 0) {
                        pq.offer(first);
                    }
                }
            }

            return result.toString();
        }

    }
}
