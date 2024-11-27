package org.learning.dsa.dynamic_programming;

public class MinimumInsertionsToMakeStringPallindrome1312 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][] dp;
        public int minInsertions(String s) {
            return s.length() - longestPalindromeSubseq(s);
        }

        public int longestPalindromeSubseq(String s) {
            dp = new Integer[s.length()][s.length()];
            return getLongestPalindromeSubseq(0, s.length() - 1, s);
        }

        private int getLongestPalindromeSubseq(int i, int j, String s){
            if(i > j ) return 0;
            if (i == j) return 1;
            if(dp[i][j] != null) return dp[i][j];
            int total = 0;
            if(s.charAt(i) == s.charAt(j)){
                total = 2 + getLongestPalindromeSubseq(i + 1, j - 1, s);
            }else{
                total = Math.max(getLongestPalindromeSubseq(i , j - 1, s),
                        getLongestPalindromeSubseq(i + 1, j, s));
            }
            dp[i][j] = total;
            return total;
        }
    }
}
