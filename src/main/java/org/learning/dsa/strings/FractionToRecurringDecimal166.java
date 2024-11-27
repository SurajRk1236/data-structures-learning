package org.learning.dsa.strings;

import java.util.HashMap;

public class FractionToRecurringDecimal166 {
    public static void main(String[] args) {

    }

    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) {
                return "0";
            }

            StringBuilder result = new StringBuilder();

            // Determine the sign of the result
            if ((numerator < 0) ^ (denominator < 0)) {
                result.append("-");
            }

            // Convert to long to handle edge cases like Integer.MIN_VALUE
            long num = Math.abs((long) numerator);
            long den = Math.abs((long) denominator);

            // Append the whole number part
            result.append(num / den);
            long remainder = num % den;

            if (remainder == 0) {
                return result.toString(); // No fractional part
            }

            // Start processing the fractional part
            result.append(".");
            HashMap<Long, Integer> remainderMap = new HashMap<>();

            while (remainder != 0) {
                // If the remainder is already seen, we found a recurring part
                if (remainderMap.containsKey(remainder)) {
                    int recurringIndex = remainderMap.get(remainder);
                    result.insert(recurringIndex, "(");
                    result.append(")");
                    break;
                }

                // Store the position of the remainder
                remainderMap.put(remainder, result.length());

                // Multiply the remainder by 10 to get the next digit
                remainder *= 10;
                result.append(remainder / den);
                remainder %= den;
            }

            return result.toString();
        }
    }
}
