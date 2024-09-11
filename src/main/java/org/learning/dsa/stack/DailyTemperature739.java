package org.learning.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 76, 77, 78, 79})));
    }

    public static int[] dailyTemperatures(int[] T) {
        // Initialize the result array with all 0's.
        int[] result = new int[T.length];

        // Stack to store indices of temperatures.
        Stack<Integer> stack = new Stack<>();
        // Traverse the array.
        for (int i = 0; i < T.length; i++) {
            // Check if the current temperature is warmer than the temperature
            // represented by the index at the top of the stack.
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop(); // Pop the index from the stack.
                result[index] = i - index; // Calculate the number of days.
            }
            // Push the current index onto the stack.
            stack.push(i);
        }

        return result; // Return the final result array.
    }
}
