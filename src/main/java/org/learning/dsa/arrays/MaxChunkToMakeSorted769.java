package org.learning.dsa.arrays;

/**
 * in this program we need to give the max number of buckets to be created to make it sorted
 * Approach:
 * The key observation to solve this problem is:
 *
 * At any point in the array, if the maximum value of the current subarray (from the start up to that point) is equal to the index itself, you can safely make a chunk there.
 * This is because if the maximum value up to an index i is i, it means all values from 0 to i must be in the subarray, and hence sorting it will result in 0 to i being in correct order.
 */

public class MaxChunkToMakeSorted769 {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{4,3,2,1,0}));
    }

    public static int maxChunksToSorted(int[] arr) {
        // Initialize a variable to keep track of the number of chunks
        int chunks = 0;

        // Initialize a variable to keep track of the maximum value encountered so far
        int maxSoFar = 0;

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Update maxSoFar to be the maximum of the current maxSoFar and the current element in the array
            maxSoFar = Math.max(maxSoFar, arr[i]);

            // If the maximum value up to this point equals the current index,
            // it indicates that all numbers from 0 to i can be sorted independently
            if (maxSoFar == i) {
                // Increment the chunk count as we can split the array into a chunk here
                chunks++;
            }
        }

        // Return the total number of chunks
        return chunks;
    }

}
