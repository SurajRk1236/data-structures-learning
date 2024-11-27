package org.learning.dsa.heaps;
import java.util.*;

public class CuttOfTreesGolfEvent675 {
    public static void main(String[] args) {

    }



    class Solution {
        public int cutOffTree(List<List<Integer>> forest) {
            // Step 1: Initialize the Priority Queue to store trees (height, row, col)
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            int rows = forest.size();
            int cols = forest.get(0).size();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int height = forest.get(i).get(j);
                    if (height > 1) {
                        pq.offer(new int[]{height, i, j});
                    }
                }
            }

            // Step 2: Initialize starting point (0, 0)
            int totalSteps = 0;
            int startX = 0;
            int startY = 0;

            // Step 3: Process each tree in increasing order of height
            while (!pq.isEmpty()) {
                int[] tree = pq.poll();  // Get the tree with the smallest height
                int targetX = tree[1];
                int targetY = tree[2];

                // Step 4: Use BFS to find the shortest path to this tree
                int steps = bfs(forest, startX, startY, targetX, targetY);

                if (steps == -1) {
                    return -1;  // If unreachable, return -1
                }

                totalSteps += steps;
                startX = targetX;
                startY = targetY;
            }

            return totalSteps;
        }

        // BFS function to find the shortest path from (startX, startY) to (targetX, targetY)
        private int bfs(List<List<Integer>> forest, int startX, int startY, int targetX, int targetY) {
            if (startX == targetX && startY == targetY) {
                return 0;  // Already at the target
            }

            int rows = forest.size();
            int cols = forest.get(0).size();
            boolean[][] visited = new boolean[rows][cols];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startX, startY, 0});  // {x, y, steps}
            visited[startX][startY] = true;

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // 4 possible directions (up, down, left, right)

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                int steps = curr[2];

                // Explore the 4 possible directions
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && forest.get(newX).get(newY) != 0) {
                        if (newX == targetX && newY == targetY) {
                            return steps + 1;  // Return the number of steps to reach the target
                        }
                        queue.offer(new int[]{newX, newY, steps + 1});
                        visited[newX][newY] = true;
                    }
                }
            }

            return -1;  // If target is unreachable
        }
    }

}
