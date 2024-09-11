package org.learning.dsa.strings;

public class LongestPalindromicString5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public  static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around a single character (odd-length palindromes)
            int len1 = expandAroundCenter(s, i, i);
            // Expand around two consecutive characters (even-length palindromes)
            int len2 = expandAroundCenter(s, i, i + 1);

            // Choose the longer one
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }
}
