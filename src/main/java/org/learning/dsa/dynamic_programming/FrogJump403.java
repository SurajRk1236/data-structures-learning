package org.learning.dsa.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FrogJump403 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean canCross(int[] stones) {
            // Map to store the index of each stone for quick lookup
            Map<Integer, Integer> stoneIndices = new HashMap<>();
            for (int i = 0; i < stones.length; i++) {
                stoneIndices.put(stones[i], i);
            }

            // Create a DP array for memoization
            int n = stones.length;
            boolean[][] dp = new boolean[n][n]; // dp[i][j] = can we reach stone i with jump j?

            // Start recursion with precomputed stone indices
            return canReach(stones, 0, 0, dp, stoneIndices);
        }

        private boolean canReach(int[] stones, int index, int lastJump, boolean[][] dp, Map<Integer, Integer> stoneIndices) {
            // Base case: If the frog reaches the last stone
            if (index == stones.length - 1) {
                return true;
            }

            // Check memoized result
            if (dp[index][lastJump]) {
                return false;
            }

            // Try all possible jump distances: lastJump-1, lastJump, lastJump+1
            for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
                if (jump > 0) { // Jump distance must be positive
                    int nextStone = stones[index] + jump;
                    if (stoneIndices.containsKey(nextStone)) {
                        int nextIndex = stoneIndices.get(nextStone);
                        if (canReach(stones, nextIndex, jump, dp, stoneIndices)) {
                            return true;
                        }
                    }
                }
            }

            // Memoize the result
            dp[index][lastJump] = true;
            return false;
        }
    }

}
