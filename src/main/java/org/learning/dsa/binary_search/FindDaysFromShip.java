package org.learning.dsa.binary_search;

public class FindDaysFromShip {
    public static void main(String[] args) {
        System.out.println(findDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public static int findDays(int[] arr, int day) {
        int low = 0;
        int high = 0;
        for (int j : arr) {
            low = Math.max(low, j);
            high = high + j;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (condition(mid, day, arr)) {
                high = mid;
            } else
                low = mid + 1;
        }
        return low;
    }

    private static boolean condition(int m, int day, int[] arr) {
        int noOfDays = 1;
        int total = 0;
        for (int j : arr) {
            total += j;
            if (total > m) {
                noOfDays++;
                total = j;
                if (noOfDays > day) {
                    return false;
                }
            }
        }
        return true;
    }
}
