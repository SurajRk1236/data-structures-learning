package org.learning.dsa.greedy;

public class MinimumMovesToMoveChips1217 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minCostToMoveChips(int[] position) {
            int evenCount = 0, oddCount = 0;

            // Count chips at even and odd positions
            for (int pos : position) {
                if (pos % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            // Minimum cost is to move the smaller group to the position of the larger group
            return Math.min(evenCount, oddCount);
        }
    }
}
