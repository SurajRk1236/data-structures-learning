package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class KthWeakestRowInMatrix1337 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
// Min-heap to store rows based on the number of soldiers and row index
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
                // Compare by the number of soldiers
                if (a[0] != b[0]) {
                    return a[0] - b[0]; // Fewer soldiers first
                } else {
                    return a[1] - b[1]; // Tie-breaking by row index
                }
            });

            // Iterate over each row and count the number of soldiers (1's)
            for (int i = 0; i < mat.length; i++) {
                int numSoldiers = countSoldiers(mat[i]);  // Count the number of 1's in the row
                minHeap.offer(new int[]{numSoldiers, i}); // Store {number of soldiers, row index}
            }

            // Extract the k weakest rows
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = minHeap.poll()[1];  // Get the row index from the heap
            }

            return result;
        }

        // Helper function to count the number of soldiers in a row using binary search
        private int countSoldiers(int[] row) {
            int low = 0, high = row.length;
            while (low < high) {
                int mid = (low + high) / 2;
                if (row[mid] == 1) {
                    low = mid + 1;  // Move to the right if we still have soldiers
                } else {
                    high = mid;  // Move to the left if we encounter a civilian (0)
                }
            }
            return low;  // low will be the count of soldiers
        }

    }
}
