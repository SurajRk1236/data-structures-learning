package org.learning.dsa.dynamic_programming;

public class BestTimeToBuySellStockIV188 {
    public static void main(String[] args) {

    }

    class Solution {
        Integer[][][] dp;
        public int maxProfit(int k, int[] prices) {
            dp = new Integer[prices.length][2][k + 1];
            return getMaxProfit(0, 0, 0, prices, k);
        }

        private int getMaxProfit(int i, int buy, int count, int[] prices, int k){
            if(i >= prices.length) return 0;
            if(count >= k && buy == 0) return 0;
            if(dp[i][buy][count] != null) return dp[i][buy][count];
            int profit = 0;
            if(buy == 0){
                profit = Math.max((-prices[i]  + getMaxProfit(i + 1, 1, count + 1, prices,k)),
                        getMaxProfit(i + 1, 0, count, prices,k));
            }else{
                profit = Math.max((prices[i]  + getMaxProfit(i + 1, 0, count,prices,k)),
                        getMaxProfit(i + 1, 1, count, prices,k));
            }
            return dp[i][buy][count] = profit;
        }
    }
}
