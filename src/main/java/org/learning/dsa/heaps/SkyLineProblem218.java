package org.learning.dsa.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SkyLineProblem218 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            // Step 1: Create a list of events (start and end points of buildings)
            List<int[]> events = new ArrayList<>();

            for (int[] building : buildings) {
                int left = building[0];
                int right = building[1];
                int height = building[2];
                // Add start event: (x = left, height = height)
                events.add(new int[] {left, -height});
                // Add end event: (x = right, height = height)
                events.add(new int[] {right, height});
            }

            // Step 2: Sort events
            // If two events have the same x, we process the start event first
            events.sort((a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0]; // Sort by x-coordinate
                }
                return a[1] - b[1]; // Process higher start points (-height) first, and then end points (height)
            });

            // Step 3: Use a max heap to store the current heights
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
            maxHeap.offer(0); // Initial ground height (0)

            List<List<Integer>> result = new ArrayList<>();
            int previousMaxHeight = 0;

            // Step 4: Process each event
            for (int[] event : events) {
                int x = event[0];
                int height = event[1];

                if (height < 0) {
                    // Start event: Add height to the heap
                    maxHeap.offer(-height);
                } else {
                    // End event: Remove height from the heap
                    maxHeap.remove(height);
                }

                // Step 5: Get the current max height from the heap
                int currentMaxHeight = maxHeap.peek();

                // Step 6: If the max height changes, add the key point
                if (currentMaxHeight != previousMaxHeight) {
                    result.add(Arrays.asList(x, currentMaxHeight));
                    previousMaxHeight = currentMaxHeight;
                }
            }

            return result;
        }
    }
}
