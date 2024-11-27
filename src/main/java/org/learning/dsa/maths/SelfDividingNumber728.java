package org.learning.dsa.maths;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber728 {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(47, 85));

    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> requiredData = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (checkSelfDividingNumber(i))
                requiredData.add(i);
        }
        return requiredData;
    }

    private static boolean checkSelfDividingNumber(int num) {

        int divisor = num;

        while (divisor > 0) {
            int remainder = divisor % 10;
            if (remainder == 0 || num % remainder != 0)
                return false;
            divisor = divisor / 10;
        }
        return true;
    }
}
