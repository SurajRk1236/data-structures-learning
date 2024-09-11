package org.learning.dsa.bit_manipulation;

public class MinBitFlipsRequired2220 {
    public static void main(String[] args) {
        System.out.println(minFlips(10,7));
    }
    public static int minFlips(int n,int goal) {
        int xor = n ^ goal;
        // Count the number of 1s in the XOR result
        int count = 0;
        while (xor != 0) {
            // Increment count if the last bit is 1
            count += xor & 1;
            // Right shift xor to check the next bit
            xor >>= 1;
        }

        return count;
    }
}
