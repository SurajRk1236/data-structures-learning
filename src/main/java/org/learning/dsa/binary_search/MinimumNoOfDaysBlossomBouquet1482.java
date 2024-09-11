package org.learning.dsa.binary_search;

public class MinimumNoOfDaysBlossomBouquet1482 {
    public static void main(String[] args) {
        System.out.println(Math.ceil(5/(double)4));
        System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 2));
    }

    public static int minDays(int[] bloomDay, int m, int k) {

        if (m * k > bloomDay.length) {
            return -1; // Not enough flowers to create the required bouquets
        }
        int left = 0;
        int right = 0;
        for (int bloom : bloomDay) {
            right = Math.max(right, bloom);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (condition(mid, bloomDay, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return condition(left, bloomDay, m, k) ? left : -1;
    }

    private static boolean condition(int days, int[] bloomDay, int m, int k) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            // Check if the current flower is bloomed within 'days'
            if (bloom <= days) {
                flowers++; // Increment flower count
                if (flowers == k) { // If we have enough flowers to make a bouquet
                    bouquets++; // Make a bouquet
                    flowers = 0; // Reset the flower count for the next bouquet
                }
            } else {
                flowers = 0; // Reset the flower count if the flower isn't bloomed
            }

            // If we have made enough bouquets, return true
            if (bouquets >= m) {
                return true;
            }
        }

        // If we can't make enough bouquets, return false
        return false;
    }
}
