package org.learning.dsa.strings;

public class RotateString796 {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde","cdeab"));
    }

    public static boolean rotateString(String s, String goal) {
        // Check if both strings have the same length
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if goal is a substring of s + s
        String doubledS = s + s;
        return doubledS.contains(goal);
    }
}
