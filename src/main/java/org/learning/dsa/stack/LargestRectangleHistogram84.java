package org.learning.dsa.stack;

import java.util.Stack;

public class LargestRectangleHistogram84 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];  // Array to store the left boundaries
        int[] right = new int[n]; // Array to store the right boundaries

        // Stack to help in calculating the left and right boundaries
        Stack<Integer> stack = new Stack<>();

        // Fill the left array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and the current bar is lower or equal to the stack's top
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // If the stack is empty, it means no smaller element on the left, so left boundary is -1
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack to reuse for calculating the right array
        stack.clear();

        // Fill the right array
        for (int i = n - 1; i >= 0; i--) {
            // While stack is not empty and the current bar is lower or equal to the stack's top
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // If the stack is empty, it means no smaller element on the right, so right boundary is n
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the maximum area using the left and right arrays
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1; // Width of the rectangle
            int area = heights[i] * width;      // Area of the rectangle
            maxArea = Math.max(maxArea, area);  // Update the maximum area
        }

        return maxArea;
    }
}
