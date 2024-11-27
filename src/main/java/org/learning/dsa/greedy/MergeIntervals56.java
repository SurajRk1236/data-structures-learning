package org.learning.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }

            // Sort intervals based on the start times
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            List<int[]> merged = new ArrayList<>();

            // Start with the first interval
            int[] currentInterval = intervals[0];
            merged.add(currentInterval);

            for (int[] interval : intervals) {
                int currentStart = currentInterval[0];
                int currentEnd = currentInterval[1];
                int nextStart = interval[0];
                int nextEnd = interval[1];

                if (currentEnd >= nextStart) { // Overlapping intervals
                    currentInterval[1] = Math.max(currentEnd, nextEnd); // Merge intervals
                } else { // No overlap, add the current interval and move to the next
                    currentInterval = interval;
                    merged.add(currentInterval);
                }
            }

            return merged.toArray(new int[merged.size()][]);

        }
    }
}
