package org.learning.dsa.dynamic_programming;

import java.util.Arrays;

public class DistinctSubsequence115 {
    public static void main(String[] args) {

    }

    class Solution {
        public int numDistinct(String s, String t) {
            Integer[][] dp = new Integer[s.length()][t.length()];
            return getNumDistinct(s.length() - 1, t.length() - 1, s, t, dp);
        }

        private int getNumDistinct(int i, int j, String s, String t, Integer[][] dp) {
            if (j < 0)
                return 1;
            if (i < 0)
                return 0;
            if (dp[i][j] != null)
                return dp[i][j];
            if (s.charAt(i) == t.charAt(j)) {
                return dp[i][j] = getNumDistinct(i - 1, j - 1, s, t, dp) + getNumDistinct(i - 1, j, s, t, dp);
            }
            return dp[i][j] = getNumDistinct(i - 1, j, s, t, dp);
        }
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i<=n; i++) dp[i][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}
