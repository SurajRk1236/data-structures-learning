package org.learning.dsa.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI194 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{}, new int[]{1})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Stack to maintain decreasing sequence
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 from left to right
        for (int num : nums2) {
            // While the current number is greater than the number at the top of the stack,
            // it means the current number is the next greater element for the stack's top number
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current number to the stack
            stack.push(num);
        }

        // For any numbers left in the stack, there is no next greater element, so we map them to -1
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        // For nums1, retrieve the next greater element from the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}
