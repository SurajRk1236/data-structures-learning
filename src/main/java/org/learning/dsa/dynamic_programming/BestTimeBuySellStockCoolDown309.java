package org.learning.dsa.dynamic_programming;

public class BestTimeBuySellStockCoolDown309 {
    public static void main(String[] args) {

    }
    class Solution {
        Integer[][] dp;
        public int maxProfit(int[] prices) {
            dp = new Integer[prices.length][2];
            return getMaxProfit(0, 0, prices);
        }

        private int getMaxProfit(int i, int buy, int[] prices){
            if(i >= prices.length) return 0;
            if(dp[i][buy] != null) return dp[i][buy];
            int profit = 0;
            if(buy == 0){
                profit = Math.max((-prices[i] + getMaxProfit(i + 1, 1, prices)),
                        getMaxProfit(i + 1, 0, prices));
            }else{
                profit = Math.max((prices[i] + getMaxProfit(i + 2, 0, prices)),
                        getMaxProfit(i + 1, 1, prices));
            }
            return dp[i][buy] = profit;
        }
    }
}
