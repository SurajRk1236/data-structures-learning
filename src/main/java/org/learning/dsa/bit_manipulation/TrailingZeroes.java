package org.learning.dsa.bit_manipulation;

public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(solve(-56));
    }

    private static int solve(int n) {
        int trailingZeroes = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) == 0) {
                trailingZeroes++;
            } else
                break;
        }
        return trailingZeroes;
    }
}
