package org.learning.dsa.dynamic_programming;

public class PallindromePartitioningII132 {
    public static void main(String[] args) {

    }
    class Solution {
        Integer[] dp;
        public int minCut(String s) {
            dp = new Integer[s.length()];
            return getMinPartitionCount(0, s.length(), s) - 1;
        }

        private int getMinPartitionCount(int i, int j, String s){
            if(i == j) return 0;
            if(dp[i] != null) return dp[i];
            int minCost = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                if (checkPallindrome(i, k, s)) {
                    int cost = 1 + getMinPartitionCount(k + 1, j, s);
                    minCost = Math.min(minCost, cost);
                }
            }
            return dp[i] = minCost;
        }

        private boolean checkPallindrome(int i, int j, String s){
            while(i < j){
                if(s.charAt(i) != s.charAt(j))return false;
                i++;
                j--;
            }
            return true;
        }
    }
}
