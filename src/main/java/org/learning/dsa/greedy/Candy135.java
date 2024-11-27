package org.learning.dsa.greedy;

import java.util.Arrays;

public class Candy135 {
    public static void main(String[] args) {

    }

    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            if (n == 0) return 0;

            // Initialize candy array, each child gets at least 1 candy
            int[] candies = new int[n];
            Arrays.fill(candies, 1);

            // Left-to-right pass
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }

            // Right-to-left pass
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }

            // Sum up all the candies
            int totalCandies = 0;
            for (int candy : candies) {
                totalCandies += candy;
            }

            return totalCandies;
        }
    }
}
