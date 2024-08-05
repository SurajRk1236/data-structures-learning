package org.learning.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartiontioning131 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, result, 0, new ArrayList<>());
        return result;
    }

    private static void helper(String data, List<List<String>> result, int index, List<String> temp) {
        if (index == data.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < data.length(); i++) {
            if (isPalindrome(data, index, i)) {
                temp.add(data.substring(index, i + 1));
                helper(data, result, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String temp, int l, int r) {
        char[] data = temp.toCharArray();
        while (l < r) {
            if (data[l] != data[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
}
