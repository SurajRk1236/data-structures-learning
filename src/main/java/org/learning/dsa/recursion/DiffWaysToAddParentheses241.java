package org.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToAddParentheses241 {
    public static void main(String[] args) {

    }

    private Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        // If this expression has been computed before, return cached result
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        // Loop through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If it's an operator, split the expression at this point
            if (c == '+' || c == '-' || c == '*') {
                // Divide the expression into left and right parts
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                // Recursively compute all possible results for the left and right parts
                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                // Combine the results of left and right using the current operator
                for (int leftResult : leftResults) {
                    for (int rightResult : rightResults) {
                        if (c == '+') {
                            result.add(leftResult + rightResult);
                        } else if (c == '-') {
                            result.add(leftResult - rightResult);
                        } else {
                            result.add(leftResult * rightResult);
                        }
                    }
                }
            }
        }

        // If there are no operators in the expression, it's a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        // Cache the result for this expression
        memo.put(expression, result);

        return result;
    }
}
