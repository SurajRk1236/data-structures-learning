package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class KthLargestElementInStream703 {

    public static void main(String[] args) {

    }
    class KthLargest {

        // Min-Heap to store the top 'k' largest elements
        private PriorityQueue<Integer> minHeap;
        private int k;

        // Constructor to initialize the class with k and the initial array of numbers
        public KthLargest(int k, int[] nums) {
            this.k = k;
            // Initialize a min-heap (PriorityQueue in Java)
            minHeap = new PriorityQueue<>();

            // Add all initial elements to the heap, but keep only the top 'k' largest
            for (int num : nums) {
                add(num);  // Use add method to maintain the heap size
            }
        }

        // Add method to insert a new element into the stream
        public int add(int val) {
            // Add the new element to the min-heap
            minHeap.offer(val);

            // If the heap size exceeds 'k', remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the root (smallest element)
            }

            // The root of the min-heap is the kth largest element
            return minHeap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
