package org.learning.dsa.arrays;

public class IntegerToRoman12 {
    public static void main(String[] args) {

    }

    class Solution {
        public String intToRoman(int num) {
            // Roman numeral symbols and their values
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder roman = new StringBuilder();

            // Greedily match the largest values first
            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    num -= values[i];
                    roman.append(symbols[i]);
                }
            }
            return roman.toString();
        }
    }
}
