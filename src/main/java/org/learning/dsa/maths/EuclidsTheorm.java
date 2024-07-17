package org.learning.dsa.maths;

public class EuclidsTheorm {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(40,84));
    }

    private static int greatestCommonDivisor(int a, int b) {
        if (b==0)
            return a;
        return greatestCommonDivisor(b, a % b);
    }
}
