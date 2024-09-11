package org.learning.dsa.recursion;
//https://leetcode.com/problems/regular-expression-matching/submissions/1379949110/
public class RegularExpressionMatching10 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }

    public static boolean isMatch(String s, String p) {
        // Base case: if the pattern is empty, the string must also be empty
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // Check if the first character matches or if the pattern contains '.'
        boolean firstMatch = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // If the second character of the pattern is '*', we have two choices:
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 1. Ignore the current pattern character and '*' (move past `x*` in pattern)
            // 2. Or, use '*' if the first character matches and recursively check remaining
            // string
            return (isMatch(s, p.substring(2)) ||
                    (firstMatch && isMatch(s.substring(1), p)));
        } else {
            // If no '*' present, proceed to the next character in both the string and
            // pattern
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

}
