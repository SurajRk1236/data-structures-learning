package org.learning.dsa.strings;

public class CountSubStringThatDifferBy1Char1638 {
    public static void main(String[] args) {

    }

    class Solution {

        public int countSubstrings(String s, String t) {
            int m = s.length();
            int n = t.length();
            int result = 0;

            // Compare substrings starting at every index of s and t
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result += countDifferentByOne(s, t, i, j);
                }
            }

            return result;
        }

        // Helper function to count substrings starting from i and j that differ by
        // exactly one character
        private int countDifferentByOne(String s, String t, int i, int j) {
            int m = s.length();
            int n = t.length();
            int diffCount = 0; // Counts the number of differing characters
            int totalCount = 0; // Counts valid substrings that differ by exactly one character

            // Compare substrings starting at index i in s and index j in t
            while (i < m && j < n) {
                if (s.charAt(i) != t.charAt(j)) {
                    diffCount++;
                }

                // If we have exactly one differing character, increment the result count
                if (diffCount == 1) {
                    totalCount++;
                } else if (diffCount > 1) {
                    break; // Stop if there's more than one difference
                }

                i++;
                j++;
            }

            return totalCount;
        }
    }
}
