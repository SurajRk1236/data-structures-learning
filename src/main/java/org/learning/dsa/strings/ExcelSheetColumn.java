package org.learning.dsa.strings;

public class ExcelSheetColumn {
    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder column = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            column.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return column.reverse().toString();
    }
}
