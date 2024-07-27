package org.learning.dsa.bit_manipulation;

public class DivideTheNumber {
    public static void main(String[] args) {
        System.out.println(divide(7, -3));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == divisor) {
            return 1;
        }
        boolean sign = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int ans = 0;
        while (dividend >= divisor) {
            int count = 0;
            while (dividend >= divisor << (count + 1)) {
                count++;
            }
            ans += 1 << count;
            dividend -= (divisor << count);
        }
        return sign ? -ans : ans;
    }

}
