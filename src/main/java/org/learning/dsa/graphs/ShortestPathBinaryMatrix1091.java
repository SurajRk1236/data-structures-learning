package org.learning.dsa.graphs;
import java.util.*;

public class ShortestPathBinaryMatrix1091 {
    public static void main(String[] args) {

    }


    class Solution {
        class Pair{
            int row;
            int col;
            int dist;

            Pair(int row, int col, int dist){
                this.row = row;
                this.col = col;
                this.dist = dist;
            }
        }
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if(n == 1) return grid[0][0] == 1 ? -1 : 1;
            if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
            int[][] distance = getInitialDistanceMatrix(n);
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(0, 0, 1));
            while(!queue.isEmpty()){
                Pair pair = queue.poll();
                int row = pair.row;
                int col = pair.col;
                int dist = pair.dist;
                for(int[] dir : get8Directions()){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    int newDist = dist + 1;
                    if(isValidGrid(newRow, newCol, n, grid, distance, newDist)){
                        distance[newRow][newCol] = newDist;
                        queue.offer(new Pair(newRow, newCol, newDist));
                    }
                    if(newRow == n-1 && newCol == n-1) return distance[newRow][newCol];
                }
            }
            return -1;
        }

        private int[][] getInitialDistanceMatrix(int n){
            int[][] dist = new int[n][n];
            for(int i = 0; i < n; i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            return dist;
        }

        private int[][] get8Directions(){
            int[][] allDirections = {{-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},            {0, 1},
                    {1, -1}, {1, 0}, {1, 1}};
            return allDirections;
        }

        private boolean isValidGrid(int i, int j, int n, int[][] grid, int[][] distance, int dist){
            return i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 0 && distance[i][j] > dist;
        }

    }
}
