package org.learning.dsa.bit_manipulation;

public class AlternateBit {
    public static void main(String[] args) {
        System.out.println(check(9));
    }

    private static boolean check(int n){
        int prevBit = n & 1; // Extract the least significant bit
        n >>= 1; // Shift right to process the next bit

        while (n > 0) {
            int currentBit = n & 1; // Extract the current bit
            if (currentBit == prevBit) {
                return false; // If two consecutive bits are the same, return false
            }
            prevBit = currentBit; // Update prevBit
            n >>= 1;
        }

        return true;
    }
}
