package org.learning.dsa.bit_manipulation;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(25));
    }

    private static int reverseBits(int s) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (s >> i) & 1;
            result |= (bit << (31 - i));
        }
        return result;
    }
}
