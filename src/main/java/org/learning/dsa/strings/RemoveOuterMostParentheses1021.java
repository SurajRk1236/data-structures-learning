package org.learning.dsa.strings;

public class RemoveOuterMostParentheses1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                if (openCount > 0) {
                    result.append(ch);
                }
                openCount++;
            } else if (ch == ')') {
                openCount--;
                if (openCount > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
