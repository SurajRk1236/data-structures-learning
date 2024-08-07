package org.learning.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int ob = 0;
        int cb = 0;
        helper(result, n, ob, cb, new StringBuilder());
        return result;
    }

    private static void helper(List<String> result, int n, int ob, int cb, StringBuilder data) {
        if (n * 2 == data.length()) {
            result.add(data.toString());
            return;
        }

        if (ob < n) {
            data.append("(");
            helper(result, n, ob + 1, cb, data);
            data.deleteCharAt(data.length() - 1);
        }

        if (ob > cb) {
            data.append(")");
            helper(result, n, ob, cb + 1, data);
            data.deleteCharAt(data.length() - 1);
        }
    }
}
