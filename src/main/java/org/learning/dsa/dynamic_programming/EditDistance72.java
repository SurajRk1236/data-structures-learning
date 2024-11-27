package org.learning.dsa.dynamic_programming;

public class EditDistance72 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();

            // DP table where dp[i][j] represents the minimum edit distance
            int[][] dp = new int[m + 1][n + 1];

            // Base case: convert empty word1 to word2
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }

            // Base case: convert empty word2 to word1
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }

            // Fill the DP table
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // If characters match, no operation needed
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // Minimum of insert, delete, and replace
                        dp[i][j] = Math.min(dp[i - 1][j - 1], // Replace
                                Math.min(dp[i][j - 1], // Insert
                                        dp[i - 1][j])) // Delete
                                + 1;
                    }
                }
            }

            // The answer is in dp[m][n]
            return dp[m][n];
        }
    }
}
