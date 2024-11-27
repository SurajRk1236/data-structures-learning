package org.learning.dsa.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ReOrganizeString767 {
    public static void main(String[] args) {

    }

    class Solution {
        public String reorganizeString(String s) {
            Map<Character, Integer> map = new HashMap<>();
            TreeSet<Character> set = new TreeSet<>();

            // Step 1: Count the frequency of each character
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // Step 2: Use a max-heap (PriorityQueue) to store the characters by frequency
            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

            // Step 3: Add all entries from the map into the priority queue
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                pq.offer(entry);
            }

            StringBuilder result = new StringBuilder();

            // Step 4: Reorganize the string
            while (pq.size() > 1) {
                // Get the two most frequent characters
                Map.Entry<Character, Integer> firstMax = pq.poll();
                Map.Entry<Character, Integer> secondMax = pq.poll();

                // Append them to the result
                result.append(firstMax.getKey());
                result.append(secondMax.getKey());

                // Decrease their frequencies
                firstMax.setValue(firstMax.getValue() - 1);
                secondMax.setValue(secondMax.getValue() - 1);

                // If their frequency is still greater than 0, put them back into the priority queue
                if (firstMax.getValue() > 0) {
                    pq.offer(firstMax);
                }
                if (secondMax.getValue() > 0) {
                    pq.offer(secondMax);
                }
            }

            // If there's one character left, check if it can be placed without repeating
            if (!pq.isEmpty()) {
                Map.Entry<Character, Integer> lastEntry = pq.poll();
                if (lastEntry.getValue() > 1) {
                    return "";  // It's not possible to reorganize the string
                }
                result.append(lastEntry.getKey());
            }

            return result.toString();
        }
    }
}
