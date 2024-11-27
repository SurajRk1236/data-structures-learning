package org.learning.dsa.dynamic_programming;

public class ShortestCommonSuperSequence1092 {
    public static void main(String[] args) {
    }

    class Solution {
        int[][] dp;

        public String shortestCommonSupersequence(String str1, String str2) {
            // Step 1: Calculate LCS and populate dp table
            longestCommonSubsequence(str1, str2);

            int i = str1.length();
            int j = str2.length();
            StringBuilder answer = new StringBuilder();

            // Step 2: Build the shortest common supersequence using the LCS
            while (i > 0 && j > 0) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // If characters match, include it in the result
                    answer.append(str1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    // If top cell has higher LCS, move up
                    answer.append(str1.charAt(i - 1));
                    i--;
                } else {
                    // If left cell has higher LCS, move left
                    answer.append(str2.charAt(j - 1));
                    j--;
                }
            }

            // Step 3: Append remaining characters
            while (i > 0) {
                answer.append(str1.charAt(i - 1));
                i--;
            }
            while (j > 0) {
                answer.append(str2.charAt(j - 1));
                j--;
            }

            // Reverse the result as we built it backwards
            return answer.reverse().toString();
        }

        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            dp = new int[m + 1][n + 1]; // Initialize dp with dimensions (m+1) x (n+1)

            // Fill dp array with LCS values using bottom-up approach
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }

}
