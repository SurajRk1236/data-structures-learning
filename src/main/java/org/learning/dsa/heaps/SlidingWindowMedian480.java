package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class SlidingWindowMedian480 {
    public static void main(String[] args) {

    }


    public class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            double[] result = new double[n - k + 1];

            // Max heap for the smaller half, Min heap for the larger half
            PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b - a);
            PriorityQueue<Integer> right = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                // Add the current element to the heaps
                addNum(nums[i], left, right);

                // Remove the element that's sliding out of the window
                if (i >= k) {
                    removeNum(nums[i - k], left, right);
                }

                // Calculate the median for the current window
                if (i >= k - 1) {
                    result[i - k + 1] = getMedian(left, right, k);
                }
            }

            return result;
        }

        // Add number to the appropriate heap and maintain balance
        private void addNum(int num, PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            // Balance the heaps
            balanceHeaps(left, right);
        }

        // Remove number from the appropriate heap and maintain balance
        private void removeNum(int num, PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
            if (num <= left.peek()) {
                left.remove(num);
            } else {
                right.remove(num);
            }

            // Balance the heaps
            balanceHeaps(left, right);
        }

        // Balance the heaps so that the size of left is equal or 1 more than right
        private void balanceHeaps(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            } else if (right.size() > left.size()) {
                left.offer(right.poll());
            }
        }

        // Get the median from the heaps
        private double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int k) {
            if (k % 2 == 0) {
                return ((double) left.peek() + right.peek()) / 2;
            } else {
                return (double) left.peek();
            }
        }
    }

}
