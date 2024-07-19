package org.learning.dsa.maths;

public class FactorTrailingZeros {
    public static void main(String[] args) {
        System.out.println(factorTrailingZero(100));
    }

    private static int factorTrailingZero(int n) {
        int count = 0;
        for (int i = 5; i <= n; i*=5) {
            count += n/i;
        }
        return count;
    }

}
