package org.learning.dsa.dynamic_programming;

import java.util.Arrays;

public class LongestStringChain1048 {
    public static void main(String[] args) {

    }

    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, (a, b) -> (a.length() - b.length()));
            int[] dp = new int[words.length];
            int maxLength = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (compareString(words[i], words[j]) && 1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                    }
                }
                maxLength = Math.max(dp[i] + 1, maxLength);
            }
            return maxLength;
        }

        private boolean compareString(String s1, String s2){
            if(s1.length() - s2.length() != 1) return false;
            int i = 0;
            int j = 0;
            int counter = 0;
            while(i <  s1.length()){
                if(s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }else{
                    counter ++;
                    i++;
                }
            }
            return counter == 1;
        }
    }
}
