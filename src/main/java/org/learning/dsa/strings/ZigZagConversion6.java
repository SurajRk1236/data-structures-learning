package org.learning.dsa.strings;
//
public class ZigZagConversion6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        // Edge case: If only 1 row, return the string as is
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create a list of StringBuilder to represent each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse through the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // Change direction when we hit the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // Update the current row based on the direction
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

}
