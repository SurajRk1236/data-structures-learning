package org.learning.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicString205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Character> sToTMap = new HashMap<>();
        Map<Character, Character> tToSMap = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Check if there is a conflict in the s -> t mapping
            if (sToTMap.containsKey(sChar)) {
                if (sToTMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                sToTMap.put(sChar, tChar);
            }

            // Check if there is a conflict in the t -> s mapping
            if (tToSMap.containsKey(tChar)) {
                if (tToSMap.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tToSMap.put(tChar, sChar);
            }
        }
        return true;
    }
}
