package org.learning.dsa.binary_search;

public class KthElementOf2SortedArraysGFG {
    public static void main(String[] args) {

    }


    // Method to find the k-th element in the union of two sorted arrays
    public static int findKthElement(int[] arr1, int[] arr2, int k) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        // Ensure arr1 is the smaller array for binary search efficiency
        if (n1 > n2) {
            return findKthElement(arr2, arr1, k);
        }

        int low = Math.max(0, k - n2);
        int high = Math.min(n1, k);

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int left1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int left2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int right1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int right2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2); // The k-th element
            } else if (left1 > right2) {
                high = mid1 - 1; // Move left in arr1
            } else {
                low = mid1 + 1; // Move right in arr1
            }
        }

        throw new IllegalArgumentException("Input arrays are not valid.");
    }


}
