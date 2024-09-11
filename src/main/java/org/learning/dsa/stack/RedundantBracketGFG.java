package org.learning.dsa.stack;

import java.util.Stack;

public class RedundantBracketGFG {
    public static void main(String[] args) {
        System.out.println(checkRedundancy("((a+b))"));
    }

    public static boolean checkRedundancy(String expression) {
        // Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Traverse the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If current character is a closing bracket ')'
            if (ch == ')') {
                boolean operatorFound = false;
                // Pop elements until an opening bracket '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    // Check if an operator is found between the brackets
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorFound = true;
                    }
                }

                // Pop the opening bracket '('
                if (!stack.isEmpty()) {
                    stack.pop();
                }

                // If no operator was found between '(', ')', it's redundant
                if (!operatorFound) {
                    return true;
                }
            } else {
                // Push other characters (including opening brackets and operators)
                stack.push(ch);
            }
        }

        // No redundant brackets found
        return false;
    }

}
