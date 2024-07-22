package org.learning.dsa.strings;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(find("001010100100100"));
    }

    public static int find(String n) {
        int count = 0;
        for (char c : n.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
