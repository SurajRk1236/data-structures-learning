package org.learning.dsa.graphs;
import java.util.*;
public class FloodFill733 {
    public static void main(String[] args) {

    }

    class Solution {
        class Pair{
            int row;
            int col;

            Pair(int row, int col){
                this.row = row;
                this.col = col;
            }
        }
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int n = image.length;
            int m = image[0].length;
            boolean[][] visited = new boolean[n][m];
            Queue<Pair> queue = new LinkedList<>();
            int originalColor = image[sr][sc];
            image[sr][sc] = color;
            //if (originalColor == color) return image;
            visited[sr][sc] = true;
            queue.offer(new Pair(sr, sc));
            int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            while(!queue.isEmpty()){
                Pair pair = queue.poll();
                int row = pair.row;
                int col = pair.col;
                for(int[] dirc : dir){
                    int newRow = row + dirc[0];
                    int newCol = col + dirc[1];
                    if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m && image[newRow][newCol] == originalColor && !visited[newRow][newCol]){
                        visited[newRow][newCol] = true;
                        image[newRow][newCol] = color;
                        queue.offer(new Pair(newRow, newCol));
                    }
                }
            }
            return image;

        }
    }
}
