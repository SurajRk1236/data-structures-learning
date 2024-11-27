package org.learning.dsa.bit_manipulation;

public class SingleNumberIII260 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] singleNumber(int[] nums) {
            // Step 1: Find xor of the two unique numbers
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }

            // Step 2: Find the rightmost set bit in xor
            int diff = xor & -xor; // Isolates the rightmost set bit

            // Step 3: Divide numbers into two groups and find the unique numbers
            int[] result = new int[2];
            for (int num : nums) {
                if ((num & diff) == 0) {
                    result[0] ^= num; // XOR group where bit is not set
                } else {
                    result[1] ^= num; // XOR group where bit is set
                }
            }

            return result; // result[0] and result[1] are the two unique numbers
        }
    }
}
