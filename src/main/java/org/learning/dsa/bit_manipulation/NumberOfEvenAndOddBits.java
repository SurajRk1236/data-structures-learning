package org.learning.dsa.bit_manipulation;

import java.util.Arrays;

public class NumberOfEvenAndOddBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenAndOddbits(2)));
    }

    private static int[] evenAndOddbits(int n) {
        int odd = 0;
        int even = 0;
        int[] result = new int[2];
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                if (i % 2 == 0)
                    even++;
                else
                    odd++;
            }
        }
        result[0] = even;
        result[1] = odd;
        return result;
    }
}
