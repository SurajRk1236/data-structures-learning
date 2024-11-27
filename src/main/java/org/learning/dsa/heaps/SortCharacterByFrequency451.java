package org.learning.dsa.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharacterByFrequency451 {
    public static void main(String[] args) {

    }

    class Solution {
        public String frequencySort(String s) {
            // Step 1: Count the frequency of each character using a HashMap
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }

            // Step 2: Create a max-heap (priority queue) to store characters based on their
            // frequency
            PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                    (a, b) -> b.getValue() - a.getValue());

            // Step 3: Add all entries from the frequency map into the priority queue
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                maxHeap.offer(entry);
            }

            // Step 4: Build the result string by polling from the priority queue
            StringBuilder result = new StringBuilder();
            while (!maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                char character = entry.getKey();
                int frequency = entry.getValue();

                // Append the character 'frequency' times to the result
                for (int i = 0; i < frequency; i++) {
                    result.append(character);
                }
            }

            return result.toString();

        }
    }
}
