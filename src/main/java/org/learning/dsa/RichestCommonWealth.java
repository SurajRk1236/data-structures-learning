package org.learning.dsa;

public class RichestCommonWealth {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {3, 2, 1}
        };
        System.out.println(maximumWealth(array));
    }

    public static int maximumWealth(int[][] accounts) {
        int row = accounts.length;
        int column = accounts[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < column; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
