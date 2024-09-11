package org.learning.dsa.binary_search;

public class KthMissingPositiveNumber1539 {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{1, 2, 3, 4, 5}, 2));
    }

    public static int findKthPositive(int[] arr, int k) {
        int left = 1; // Minimum possible missing number
        int right = arr[arr.length - 1] + k; // Maximum possible missing number

        // Binary search to find the k-th missing number
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countMissing(arr, mid) < k) {
                left = mid + 1; // k-th missing number is larger
            } else {
                right = mid; // k-th missing number might be mid or smaller
            }
        }

        return left;
    }

    private static int countMissing(int[] arr, int num) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= num) {
                count = num - (i + 1); // Count missing numbers up to the current index
            } else {
                break;
            }
        }
        return count;
    }
}
