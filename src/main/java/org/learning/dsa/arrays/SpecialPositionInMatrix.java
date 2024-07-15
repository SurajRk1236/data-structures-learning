package org.learning.dsa.arrays;

public class SpecialPositionInMatrix {

    public static void main(String[] args) {

        int[][] mat1 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(numSpecial(mat1));
    }

    public static int numSpecial(int[][] mat) {

        int rowLength = mat.length;
        int colLength = mat[0].length;
        int[] row = new int[rowLength];
        int[] col = new int[colLength];
        int required = 0;


        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1)
                    required++;
            }
        }

        return required;
    }
}
