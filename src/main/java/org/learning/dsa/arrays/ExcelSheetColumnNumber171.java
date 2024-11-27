package org.learning.dsa.arrays;

public class ExcelSheetColumnNumber171 {
    public static void main(String[] args) {

    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            int value = ch - 'A' + 1; // Convert character to its corresponding number ('A' = 1, ..., 'Z' = 26)
            result = result * 26 + value; // Shift the previous result by multiplying by 26 and add the current value
        }

        return result;
    }
}
