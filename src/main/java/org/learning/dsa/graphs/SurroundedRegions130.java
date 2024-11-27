package org.learning.dsa.graphs;
import java.util.*;

public class SurroundedRegions130 {
    public static void main(String[] args) {

    }

    class Solution {
        class Node {
            int row;
            int col;

            Node(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        public void solve(char[][] board) {
            int n = board.length;
            int m = board[0].length;
            char zeroChar = 'O', xChar = 'X';
            boolean[][] cannotBeMarked = new boolean[n][m];

            // Run BFS from all 'O's on the borders to mark cells that should not be flipped
            for (int i = 0; i < n; i++) {
                if (board[i][0] == zeroChar) bfs(i, 0, n, m, board, cannotBeMarked);
                if (board[i][m - 1] == zeroChar) bfs(i, m - 1, n, m, board, cannotBeMarked);
            }
            for (int j = 0; j < m; j++) {
                if (board[0][j] == zeroChar) bfs(0, j, n, m, board, cannotBeMarked);
                if (board[n - 1][j] == zeroChar) bfs(n - 1, j, n, m, board, cannotBeMarked);
            }

            // Flip all 'O's that are not marked in `cannotBeMarked` to 'X'
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!cannotBeMarked[i][j] && board[i][j] == zeroChar) {
                        board[i][j] = xChar;
                    }
                }
            }
        }

        private void bfs(int r, int c, int n, int m, char[][] board, boolean[][] cannotBeMarked) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(r, c));
            cannotBeMarked[r][c] = true;
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int row = node.row;
                int col = node.col;
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !cannotBeMarked[newRow][newCol] && board[newRow][newCol] == 'O') {
                        cannotBeMarked[newRow][newCol] = true;
                        queue.offer(new Node(newRow, newCol));
                    }
                }
            }
        }
    }

}
