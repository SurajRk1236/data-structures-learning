package org.learning.dsa.greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval57 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> result = new ArrayList<>();
            int i = 0;
            int n = intervals.length;

            // Step 1: Add all intervals that end before the new interval starts
            while (i < n && intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                i++;
            }

            // Step 2: Merge overlapping intervals with newInterval
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]); // Update start
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]); // Update end
                i++;
            }
            // Add the merged interval
            result.add(newInterval);

            // Step 3: Add remaining intervals that start after the new interval ends
            while (i < n) {
                result.add(intervals[i]);
                i++;
            }

            // Convert the list back to an array
            return result.toArray(new int[result.size()][]);
        }
    }
}
