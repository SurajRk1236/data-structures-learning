package org.learning.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] data = s.trim().split(" ");
        if (pattern.length() != data.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(data[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), data[i]);
            }
        }
        return true;
    }
}
