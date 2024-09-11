package org.learning.dsa.strings;

public class LargestOddNumber1903 {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("35427"));
    }

    public static String largestOddNumber(String num) {
        int largest = 0;
        String[] data = num.split("");
        for (String datum : data) {
            int value = Integer.parseInt(datum);
            if (value % 2 != 0) {
                largest = Math.max(largest, value);
            }
        }
        return largest == 0 ? "" : String.valueOf(largest);
    }
}
