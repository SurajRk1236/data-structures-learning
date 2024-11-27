package org.learning.dsa.stack;

import java.util.*;

public class BasicCalculator227 {
    public static void main(String[] args) {

    }

    class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int currentNumber = 0; // To store the current number being parsed
            char lastOperator = '+'; // The last operator, initialized to '+'

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);

                // Build the current number
                if (Character.isDigit(currentChar)) {
                    currentNumber = currentNumber * 10 + (currentChar - '0');
                }

                // If the character is an operator or the end of the string is reached
                if (!Character.isDigit(currentChar) && currentChar != ' ' || i == s.length() - 1) {
                    switch (lastOperator) {
                        case '+':
                            stack.push(currentNumber);
                            break;
                        case '-':
                            stack.push(-currentNumber);
                            break;
                        case '*':
                            stack.push(stack.pop() * currentNumber);
                            break;
                        case '/':
                            stack.push(stack.pop() / currentNumber);
                            break;
                    }

                    // Update lastOperator and reset currentNumber
                    lastOperator = currentChar;
                    currentNumber = 0;
                }
            }

            // Sum all numbers in the stack to get the result
            int result = 0;
            for (int num : stack) {
                result += num;
            }

            return result;

        }
    }
}
