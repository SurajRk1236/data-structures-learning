package org.learning.dsa.backtracking;

import java.util.Arrays;

public class SudokuSolver37 {

    static char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    public static void main(String[] args) {
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private static boolean helper(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return helper(board, row + 1, 0);
        }
        if (board[row][col] != '.') {
            return helper(board, row, col + 1);
        }
        for (char i = '1'; i <= '9'; i++) {
            if (board[row][col] == '.') {
                if (isValid(board, row, col, i)) {
                    board[row][col] = i;
                    if (helper(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    private static boolean isValid(char[][] board, int row, int col, char value) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value || board[row][i] == value) {
                return false;
            }
        }
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r + i][c + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
