package org.learning.dsa.bit_manipulation;

public class IthBitSetGFG {
    public static void main(String[] args) {
        System.out.println(checkIthBitSet(1, 0));
    }

    private static boolean checkIthBitSet(int n, int k) {
        return (n & (1 << k)) != 0;
    }
}
