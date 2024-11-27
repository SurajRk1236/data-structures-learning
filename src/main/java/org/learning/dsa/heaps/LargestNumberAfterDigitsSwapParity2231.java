package org.learning.dsa.heaps;

import java.util.PriorityQueue;

public class LargestNumberAfterDigitsSwapParity2231 {

    public static void main(String[] args) {

    }

    class Solution {
        public int largestInteger(int num) {
            // Convert the number to a string to access individual digits
            String strNum = Integer.toString(num);

            // Priority queues for odd and even digits (max-heaps)
            PriorityQueue<Integer> oddDigits = new PriorityQueue<>((a, b) -> b - a);
            PriorityQueue<Integer> evenDigits = new PriorityQueue<>((a, b) -> b - a);

            // Separate the digits into odd and even priority queues
            for (char ch : strNum.toCharArray()) {
                int digit = ch - '0';  // Convert character to integer
                if (digit % 2 == 0) {
                    evenDigits.offer(digit);  // Even digits
                } else {
                    oddDigits.offer(digit);  // Odd digits
                }
            }

            // Rebuild the number using the largest digits of respective parity
            StringBuilder result = new StringBuilder();
            for (char ch : strNum.toCharArray()) {
                int digit = ch - '0';
                if (digit % 2 == 0) {
                    // Append the largest even digit from the priority queue
                    result.append(evenDigits.poll());
                } else {
                    // Append the largest odd digit from the priority queue
                    result.append(oddDigits.poll());
                }
            }

            // Convert the result string back to an integer
            return Integer.parseInt(result.toString());
        }
    }
}
