package org.learning.dsa.graphs;
import java.util.*;
public class PathWithMinEffort1631 {
    public static void main(String[] args) {

    }

    class Solution {
        class Pair {
            int dist;
            int row;
            int col;

            Pair(int dist, int row, int col) {
                this.dist = dist;
                this.row = row;
                this.col = col;
            }
        }

        public int minimumEffortPath(int[][] heights) {
            int n = heights.length;
            int m = heights[0].length;
            int[][] distance = getInitialDistance(n, m);
            int ans = Integer.MIN_VALUE;
            PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
            queue.offer(new Pair(0, 0, 0));
            distance[0][0] = 0;
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                int dist = pair.dist;
                int row = pair.row;
                int col = pair.col;
                for (int[] dir : getDirections()) {
                    int newRow = dir[0] + row;
                    int newcol = dir[1] + col;

                    if (isValidHieght(newRow, newcol, n, m)) {
                        int newDist = Math.max(dist, Math.abs(heights[newRow][newcol] - heights[row][col]));
                        if (newDist < distance[newRow][newcol]) {
                            distance[newRow][newcol] = newDist;
                            queue.offer(new Pair(distance[newRow][newcol], newRow, newcol));
                        }
                    }
                }
            }
            return distance[n - 1][m - 1];
        }

        private int[][] getInitialDistance(int n, int m) {
            int[][] dist = new int[n][m];
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++){
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            return dist;
        }

        private int[][] getDirections() {
            int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            return directions;
        }

        private boolean isValidHieght(int i, int j, int n, int m) {
            return i >= 0 && i < n && j >= 0 && j < m;
        }
    }
}
