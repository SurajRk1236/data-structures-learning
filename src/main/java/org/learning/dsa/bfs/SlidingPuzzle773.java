package org.learning.dsa.bfs;

import java.util.*;

public class SlidingPuzzle773 {
    public static void main(String[] args) {

    }


    class Solution {
        public int slidingPuzzle(int[][] board) {
            // Target configuration
            String target = "123450";
            // Convert the initial board to a string
            StringBuilder start = new StringBuilder();
            for (int[] row : board) {
                for (int num : row) {
                    start.append(num);
                }
            }

            // Directions for adjacent moves
            int[][] directions = {
                    {1, 3},        // Moves for index 0
                    {0, 2, 4},     // Moves for index 1
                    {1, 5},        // Moves for index 2
                    {0, 4},        // Moves for index 3
                    {1, 3, 5},     // Moves for index 4
                    {2, 4}         // Moves for index 5
            };

            // BFS setup
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.offer(start.toString());
            visited.add(start.toString());
            int moves = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String current = queue.poll();
                    if (current.equals(target)) {
                        return moves;
                    }

                    // Find the index of '0' (blank space)
                    int zeroIndex = current.indexOf('0');
                    for (int dir : directions[zeroIndex]) {
                        // Swap the blank space with the adjacent tile
                        String nextState = swap(current, zeroIndex, dir);
                        if (!visited.contains(nextState)) {
                            visited.add(nextState);
                            queue.offer(nextState);
                        }
                    }
                }
                moves++;
            }

            // If the target configuration is unreachable
            return -1;
        }

        // Helper function to swap characters in a string
        private String swap(String state, int i, int j) {
            char[] chars = state.toCharArray();
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            return new String(chars);
        }

    }
}
