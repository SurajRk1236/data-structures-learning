package org.learning.dsa.graphs;

import java.util.*;

public class RottenOranges994 {
    public static void main(String[] args) {

    }

    class Solution {
        class Pair {
            int row;
            int col;
            int time;

            Pair(int row, int col, int time) {
                this.row = row;
                this.col = col;
                this.time = time;
            }
        }

        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int noOfFreshorange = 0, noOfFreshOrangeVisited = 0, totaltime = 0;
            Queue<Pair> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        visited[i][j] = true;
                        queue.offer(new Pair(i, j, 0));
                    } else if (grid[i][j] == 1) {
                        noOfFreshorange++;
                    }
                }
            }
            List<int[]> dir = new ArrayList<>();
            dir.add(new int[] { -1, 0 });
            dir.add(new int[] { 0, 1 });
            dir.add(new int[] { 0, -1 });
            dir.add(new int[] { 1, 0 });
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                int row = pair.row;
                int col = pair.col;
                int time = pair.time;
                totaltime = Math.max(time, totaltime);
                for (int i = 0; i < 4; i++) {
                    int[] data = dir.get(i);
                    int newRow = row + data[0];
                    int newCol = col + data[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        noOfFreshOrangeVisited++;
                        queue.offer(new Pair(newRow, newCol, time + 1));
                    }
                }
            }

            return noOfFreshorange == noOfFreshOrangeVisited ? totaltime : -1;

        }
    }
}
