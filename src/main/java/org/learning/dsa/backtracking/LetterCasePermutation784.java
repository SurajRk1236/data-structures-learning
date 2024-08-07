package org.learning.dsa.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation784 {

    static Set<Character> integerChar = new HashSet<>();


    public static void main(String[] args) {
        integerChar.add('0');
        integerChar.add('1');
        integerChar.add('2');
        integerChar.add('3');
        integerChar.add('4');
        integerChar.add('5');
        integerChar.add('6');
        integerChar.add('7');
        integerChar.add('8');
        integerChar.add('9');
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s, 0, new StringBuilder(), result);
        return result;
    }

    private static void helper(String data, int index, StringBuilder temp, List<String> result) {
        if (index == data.length()) {
            result.add(temp.toString());
            return;
        }
        if (!integerChar.contains(data.charAt(index))) {
            temp.append(Character.toUpperCase(data.charAt(index)));
            helper(data, index + 1, temp, result);
            temp.deleteCharAt(temp.length() - 1);
            temp.append(Character.toLowerCase(data.charAt(index)));
            helper(data, index + 1, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        } else {
            temp.append(data.charAt(index));
            helper(data, index + 1, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
