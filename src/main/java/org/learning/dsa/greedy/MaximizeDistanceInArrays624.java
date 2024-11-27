package org.learning.dsa.greedy;

import java.util.List;

public class MaximizeDistanceInArrays624 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int minVal = arrays.get(0).get(0); // Initialize min from the first array
            int maxVal = arrays.get(0).get(arrays.get(0).size() - 1); // Initialize max from the first array
            int maxDistance = 0;

            for (int i = 1; i < arrays.size(); i++) {
                List<Integer> array = arrays.get(i);
                int currentMin = array.get(0);
                int currentMax = array.get(array.size() - 1);

                // Calculate distances with current array's min and max values against the
                // global max and min
                maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal));
                maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin));

                // Update global min and max
                minVal = Math.min(minVal, currentMin);
                maxVal = Math.max(maxVal, currentMax);
            }

            return maxDistance;
        }
    }
}
