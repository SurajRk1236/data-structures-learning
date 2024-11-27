package org.learning.dsa.recursion;

//
public class PowerOfNandX50 {
    public static void main(String[] args) {
        System.out.println(myPow(2.1, 3));
    }

    public static double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n > 0) {
            return getValue(x, n);
        } else {
            return 1 / getValue(x, Math.abs(n));
        }
    }

    private static double getValue(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double value = getValue(x, n / 2);
        if (n % 2 == 0) {
            value = value * value;
        } else {
            value = value * value * x;
        }

        return value;
    }
}
