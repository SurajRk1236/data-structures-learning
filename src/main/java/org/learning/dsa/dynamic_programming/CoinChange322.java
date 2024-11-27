package org.learning.dsa.dynamic_programming;

public class CoinChange322 {
    public static void main(String[] args) {

    }


    class Solution {
        public int coinChange(int[] coins, int amount) {
            // Create a memoization array initialized to -1
            Integer[] memo = new Integer[amount + 1];
            // Call the recursive function
            int result = coinChangeHelper(coins, amount, memo);
            return result == Integer.MAX_VALUE ? -1 : result;
        }

        private int coinChangeHelper(int[] coins, int amount, Integer[] memo) {
            // Base cases
            if (amount == 0) return 0;  // No coins needed for amount 0
            if (amount < 0) return Integer.MAX_VALUE;  // Impossible to form this amount

            // Return the memoized result if it exists
            if (memo[amount] != null) return memo[amount];

            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChangeHelper(coins, amount - coin, memo);
                if (res != Integer.MAX_VALUE) {  // Valid solution found
                    minCoins = Math.min(minCoins, res + 1);  // +1 for the current coin
                }
            }

            // Store the result in memoization array
            memo[amount] = minCoins;
            return minCoins;
        }
        }
}
