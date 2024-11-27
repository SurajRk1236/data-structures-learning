package org.learning.dsa.greedy;

public class CanPlaceFlowers605 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            int len = flowerbed.length;

            for (int i = 0; i < len; i++) {
                if (flowerbed[i] == 0 &&
                        (i == 0 || flowerbed[i - 1] == 0) &&
                        (i == len - 1 || flowerbed[i + 1] == 0)) {

                    // Plant a flower at position i
                    flowerbed[i] = 1;
                    count++;

                    // Check if we've planted enough flowers
                    if (count >= n) {
                        return true;
                    }
                }
            }

            return count >= n;
        }
    }
}
