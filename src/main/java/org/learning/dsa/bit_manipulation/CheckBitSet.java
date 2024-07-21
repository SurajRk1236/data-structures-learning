package org.learning.dsa.bit_manipulation;

public class CheckBitSet {
    public static void main(String[] args) {
        System.out.println(checkBitSet(29,5));
    }

    private static boolean checkBitSet(int num, int k) {
        return (num & (1 << k)) != 0;
    }
}
