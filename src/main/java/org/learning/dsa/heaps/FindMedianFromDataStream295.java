package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {
    public static void main(String[] args) {

    }

    class MedianFinder {
        private PriorityQueue<Integer> maxPq;  // Max-heap for the smaller half of the numbers
        private PriorityQueue<Integer> minPq;  // Min-heap for the larger half of the numbers

        public MedianFinder() {
            maxPq = new PriorityQueue<>((a, b) -> b - a); // Max heap
            minPq = new PriorityQueue<>(); // Min heap (natural ordering)
        }

        public void addNum(int num) {
            // Add to max heap first (always try to add to max heap)
            maxPq.offer(num);

            // Ensure maxPq's max is smaller than minPq's min
            if (!minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
                minPq.offer(maxPq.poll());
            }

            // Balance the heaps to make sure maxPq and minPq have equal size or maxPq is larger by 1
            if (maxPq.size() > minPq.size() + 1) {
                minPq.offer(maxPq.poll());
            } else if (minPq.size() > maxPq.size()) {
                maxPq.offer(minPq.poll());
            }
        }

        public double findMedian() {
            if (maxPq.size() > minPq.size()) {
                // Odd number of elements, maxPq will have one extra element
                return maxPq.peek();
            } else {
                // Even number of elements, median is the average of both tops
                return (maxPq.peek() + minPq.peek()) / 2.0;
            }
        }

    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
