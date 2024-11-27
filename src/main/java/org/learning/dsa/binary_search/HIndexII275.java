package org.learning.dsa.binary_search;

public class HIndexII275 {
    public static void main(String[] args) {

    }

    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                // Check if this is a valid h-index
                if (citations[mid] >= n - mid) {
                    // Move left to find a smaller index with the same condition
                    right = mid - 1;
                } else {
                    // Move right to find a valid index
                    left = mid + 1;
                }
            }

            // The h-index is determined by the number of papers with at least h citations
            return n - left;
        }
    }
}
