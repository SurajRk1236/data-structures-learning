package org.learning.dsa.dynamic_programming;

import java.util.Arrays;

public class DecodeWays91 {
    public static void main(String[] args) {

    }

    class Solution {
        int[] dp;
        public int numDecodings(String s) {
            dp = new int[s.length()];
            Arrays.fill(dp, -1);
            return decode(s, 0);
        }

        private int decode(String s, int index) {
            if (index == s.length()) {
                return 1;
            }
            if(dp[index] != -1){
                return dp[index];
            }
            if (s.charAt(index) == '0') {
                return 0;
            }
            int ways = decode(s, index + 1);
            if (index < s.length() - 1) {
                int twoDigit = Integer.parseInt(s.substring(index, index + 2));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    ways += decode(s, index + 2);
                }
            }
            dp[index] = ways;
            return ways;
        }
    }
}
