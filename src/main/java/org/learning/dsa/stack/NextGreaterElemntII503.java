package org.learning.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElemntII503 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3})));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array twice to simulate circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Current index, handling the circular behavior with %n
            int currentIndex = i % n;

            // While the stack is not empty and the current element is greater than or equal to the element
            // at the top of the stack, we pop the stack (since we are looking for the next greater element)
            while (!stack.isEmpty() && stack.peek() <= nums[currentIndex]) {
                stack.pop();
            }

            // If the stack is empty, no greater element is found, so store -1
            if (stack.isEmpty()) {
                result[currentIndex] = -1;
            } else {
                // Otherwise, the top of the stack is the next greater element
                result[currentIndex] = stack.peek();
            }

            // Push the current element onto the stack
            stack.push(nums[currentIndex]);
        }

        return result;
    }
}
