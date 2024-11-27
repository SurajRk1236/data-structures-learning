package org.learning.dsa.dynamic_programming;

public class InterLeavingString97 {
    public static void main(String[] args) {

    }
    Boolean[][] memo;
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();

            // If combined length of s1 and s2 doesn't match s3, return false immediately
            if (n1 + n2 != n3) return false;

            // Initialize memoization array
            memo = new Boolean[n1 + 1][n2 + 1];

            // Call the recursive function starting from the beginning of all strings
            return isInterleaveHelper(s1, s2, s3, 0, 0);
        }

        private boolean isInterleaveHelper(String s1, String s2, String s3, int i, int j) {
            // Base case: if both pointers reach the end, s3 has been formed
            if (i == s1.length() && j == s2.length()) return true;

            // If result is already computed, return it from memo array
            if (memo[i][j] != null) return memo[i][j];

            // Compute the index in s3 we are currently matching
            int k = i + j;

            // Check if we can take a character from s1
            boolean takeS1 = (i < s1.length() && s1.charAt(i) == s3.charAt(k)) &&
                    isInterleaveHelper(s1, s2, s3, i + 1, j);

            // Check if we can take a character from s2
            boolean takeS2 = (j < s2.length() && s2.charAt(j) == s3.charAt(k)) &&
                    isInterleaveHelper(s1, s2, s3, i, j + 1);

            // Store the result in memoization array
            memo[i][j] = takeS1 || takeS2;

            return memo[i][j];
        }
    }
}
