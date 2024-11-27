package org.learning.dsa.greedy;

import java.util.Stack;

public class RemoveDuplicateLettersLexiCographical316And1081 {
    public static void main(String[] args) {

    }

    class Solution {
        public String removeDuplicateLetters(String s) {
            // Frequency map to store the last occurrence of each character
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            // Stack to store the final result
            Stack<Character> stack = new Stack<>();
            // Set to track the characters already in the stack
            boolean[] inStack = new boolean[26];

            for (char c : s.toCharArray()) {
                // Decrease the frequency as we encounter the character
                freq[c - 'a']--;

                // If the character is already in the stack, continue
                if (inStack[c - 'a']) {
                    continue;
                }

                // Maintain lexicographical order
                while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                    // Remove the character from the stack and mark it as not used
                    inStack[stack.pop() - 'a'] = false;
                }

                // Push the current character onto the stack and mark it as used
                stack.push(c);
                inStack[c - 'a'] = true;
            }

            // Build the result string from the stack
            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }

            return result.toString();
        }
    }
}
