package org.learning.dsa.strings;

public class StringToIntegerAtoi8 {
    public static void main(String[] args) {
    System.out.println(myAtoi("1337c0d3"));
     //   System.out.println(Math.abs(-2));
    }

    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        int num = 0;
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle sign if present
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 4: Handle overflow
            if (num > (INT_MAX - digit) / 10) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }

            num = num * 10 + digit;
            i++;
        }

        // Step 5: Return the result with the correct sign
        return num * sign;
    }
}
