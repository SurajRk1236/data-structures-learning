package org.learning.dsa.dynamic_programming;

public class LongestCommonSubSequence1143 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][] dp;
        public int longestCommonSubsequence(String text1, String text2) {
            dp = new Integer[text1.length()][text2.length()];
            return getLongestCommonSubsequence(text1, text2, 0, 0);
        }

        private int getLongestCommonSubsequence(String text1, String text2, int i, int j){
            if(i >= text1.length() || j >= text2.length()) return 0;
            if(dp[i][j] != null) return dp[i][j];
            int total = 0;
            if(text1.charAt(i) == text2.charAt(j)){
                total = 1 + getLongestCommonSubsequence(text1, text2, i + 1, j + 1);
            }else{
                total = Math.max(getLongestCommonSubsequence(text1, text2, i + 1, j),
                        getLongestCommonSubsequence(text1, text2, i , j + 1));
            }
            dp[i][j] = total;
            return total;
        }
    }
}
