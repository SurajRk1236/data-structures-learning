package org.learning.dsa.dynamic_programming;

public class WildCardMatch44 {
    public static void main(String[] args) {

    }

    class Solution {
        Boolean[][] dp;
        public boolean isMatch(String s, String p) {
            dp = new Boolean[s.length()][p.length()];
            return getIsMatch(s.length() - 1, p.length() - 1, s, p);
        }

        private boolean getIsMatch(int i, int j,String s, String p){
            if(j < 0 && i < 0) return true;
            if(j < 0) return false;
            if(i < 0){
                for(int ii = 0; ii<=j ; ii++){
                    if(p.charAt(ii) != '*') return false;
                }
                return true;
            }
            if(dp[i][j] != null) return dp[i][j];
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                return dp[i][j] = getIsMatch(i - 1, j - 1, s, p);
            }else if(p.charAt(j) == '*'){
                return dp[i][j] = getIsMatch(i, j - 1, s, p) || getIsMatch(i - 1, j, s, p);
            }
            return dp[i][j] = false;
        }
    }
}
