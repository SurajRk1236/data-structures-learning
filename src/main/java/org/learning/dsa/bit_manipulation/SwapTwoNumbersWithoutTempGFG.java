package org.learning.dsa.bit_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapTwoNumbersWithoutTempGFG {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        System.out.println(swapNumbers(a, b));
    }

    private static List<Integer> swapNumbers(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new ArrayList<>(Arrays.asList(a, b));
    }
}
