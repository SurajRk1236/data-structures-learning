package org.learning.dsa.dynamic_programming;

public class BestTimeBuySellStockTransactionFee714 {
    public static void main(String[] args) {

    }
    class Solution {
        Integer[][] dp;

        public int maxProfit(int[] prices, int fee) {
            dp = new Integer[prices.length][2];
            return getMaxProfit(0, 0, prices, fee);
        }

        private int getMaxProfit(int i, int buy, int[] prices, int fee) {
            if (i >= prices.length)
                return 0;
            if (dp[i][buy] != null)
                return dp[i][buy];

            int profit;

            if (buy == 0) {
                // Choice to buy or skip
                profit = Math.max(-prices[i] + getMaxProfit(i + 1, 1, prices, fee),
                        getMaxProfit(i + 1, 0, prices, fee));
            } else {
                // Choice to sell or hold
                profit = Math.max(prices[i] - fee + getMaxProfit(i + 1, 0, prices, fee),
                        getMaxProfit(i + 1, 1, prices, fee));
            }

            return dp[i][buy] = profit;
        }
    }
}
