package org.learning.dsa.sorting;

import java.util.Arrays;

public class HIndex274 {
    public static void main(String[] args) {

    }

    class Solution {
        public int hIndex(int[] citations) {
            // Step 1: Sort citations in descending order
            Arrays.sort(citations);
            int n = citations.length;

            // Step 2: Find the maximum h-index
            for (int i = 0; i < n; i++) {
                int h = n - i; // Number of papers with at least citations[i] citations
                if (citations[i] >= h) {
                    return h;
                }
            }

            return 0;
        }
    }
}
