package org.learning.dsa.binary_search;

public class ShipWithinDaysCapacity {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for (int wieght : weights) {
            l = Math.max(l, wieght);
            r += wieght;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (condition(mid, weights, days)) {
                r = mid;
            } else
                l = mid + 1;
        }
        return l;
    }

    private static boolean condition(int mid, int[] weights, int days) {
        int currentLoad = 0;
        int requiredDays = 1;

        for (int weight : weights) {
            if (currentLoad + weight > mid) {
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }

        return requiredDays <= days;
    }
}
