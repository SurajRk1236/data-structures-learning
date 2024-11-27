package org.learning.dsa.dynamic_programming;

public class BestTimeToBuySellStockIII123 {
    public static void main(String[] args) {

    }
    class Solution {
        Integer[][][] dp;
        public int maxProfit(int[] prices) {
            dp = new Integer[prices.length][2][3];
            return getMaxProfit(0, 0, 0, prices);
        }

        private int getMaxProfit(int i, int buy, int count, int[] prices){
            if(i >= prices.length) return 0;
            if(count >= 2 && buy == 0) return 0;
            if(dp[i][buy][count] != null) return dp[i][buy][count];
            int profit = 0;
            if(buy == 0){
                profit = Math.max((-prices[i]  + getMaxProfit(i + 1, 1, count + 1, prices)),
                        getMaxProfit(i + 1, 0, count, prices));
            }else{
                profit = Math.max((prices[i]  + getMaxProfit(i + 1, 0, count,prices)),
                        getMaxProfit(i + 1, 1, count, prices));
            }
            return dp[i][buy][count] = profit;
        }
    }
}
