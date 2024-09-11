package org.learning.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> data = new HashMap<>();
        data.put('I', 1);
        data.put('V', 5);
        data.put('X', 10);
        data.put('L', 50);
        data.put('C', 100);
        data.put('D', 500);
        data.put('M', 1000);
        data.put('Z', Integer.MAX_VALUE);

        int result = 0;
        char last = 'Z';
        for (char ch : s.toCharArray()) {
            if (data.containsKey(ch)) {
                if (data.get(last) > data.get(ch))
                    result += data.get(ch);
                else
                    result += data.get(ch) - (2 * data.get(last));
                last = ch;
            }
        }
        return result;
    }
}
