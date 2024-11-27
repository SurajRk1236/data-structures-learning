package org.learning.dsa.stack;

import java.util.Stack;

public class DecodeString394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // If the character is a digit, update k (number multiplier)
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current number and string onto the stack
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for the new bracket
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // Pop the last number and string from the stack
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                // Repeat the current string and append it to the decoded string
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // If it's a letter, add it to the current string
                currentString.append(c);
            }
        }

        return currentString.toString();

    }
}
