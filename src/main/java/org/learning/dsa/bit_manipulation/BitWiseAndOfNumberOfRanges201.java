package org.learning.dsa.bit_manipulation;

public class BitWiseAndOfNumberOfRanges201 {
    public static void main(String[] args) {

    }

    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int shift = 0;
            while (m != n) {
                m >>= 1;
                n >>= 1;
                shift++;
            }
            return m << shift;
        }
    }
}
