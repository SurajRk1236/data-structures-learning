package org.learning.dsa.dynamic_programming;

public class BestTimeToBuyAndSellStockII122 {
    public static void main(String[] args) {

    }
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;

            for (int i = 1; i < prices.length; i++) {
                // If today's price is higher than yesterday's, we can profit by buying
                // yesterday and selling today
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }
    }
}
