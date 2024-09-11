package org.learning.dsa.binary_search;

public class FindSmallestDivisorGivenThreshold1283 {
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{2, 3, 5, 7, 11, 13}, 3));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1; // Minimum possible divisor
        int right = 0; // Maximum possible divisor
        for (int num : nums) {
            right = Math.max(right, num); // Find the maximum value in the array
        }

        // Binary search to find the smallest valid divisor
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateSum(nums, mid) <= threshold) {
                right = mid; // Try for a smaller divisor
            } else {
                left = mid + 1; // Need a larger divisor
            }
        }

        return left; // The smallest valid divisor
    }

    private static long calculateSum(int[] nums, int divisor) {
        long sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // Equivalent to Math.ceil(num / (double) divisor)
        }
        return sum;
    }
}
