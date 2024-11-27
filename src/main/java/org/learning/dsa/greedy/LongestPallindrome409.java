package org.learning.dsa.greedy;

public class LongestPallindrome409 {
    public static void main(String[] args) {

    }

    class Solution {
        public int longestPalindrome(String s) {
            int[] charCount = new int[128]; // To store the frequency of each character (assuming ASCII input)

            // Count the frequency of each character
            for (char c : s.toCharArray()) {
                charCount[c]++;
            }

            int length = 0;
            boolean hasOdd = false;

            // Process each character count
            for (int count : charCount) {
                if (count % 2 == 0) {
                    length += count; // Use the entire even count
                } else {
                    length += count - 1; // Use the maximum even part
                    hasOdd = true; // Mark that there's an odd count
                }
            }

            // If there is any odd count, we can place one character at the center
            if (hasOdd) {
                length += 1;
            }

            return length;
        }
    }
}
