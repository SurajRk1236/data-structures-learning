package org.learning.dsa.hashing;

import java.util.Arrays;
/**
 * this is to set any matrix col and row as zero
 * Approach 1:- use a map to store the data which row and col has 0 then set matrix to 0
 * Approach 2 :- in this any value is 0 make the corresponding row and col as zero start from1 set index
 *               first check 1st row and col has 0 keep in boolean and then make zero iterating over it.
 */

public class SetMatrixToZero73 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,3}
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;

        //check first col has zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
            }
        }

        //check first row has zero
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
            }
        }

        //set corresponding row and col to zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //make the values zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //make first col zero
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        //make first row zero
        if (firstCol) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}
