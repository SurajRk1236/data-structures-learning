package org.learning.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class AnagramString242 {
    public static void main(String[] args) {
        System.out.println(checkValidAnagram("anagram", "nagaram"));
    }

    private static boolean checkValidAnagram(String str1,String str2){
        if(str1.length() != str2.length())
            return false;
        Map<Character, Integer> data = new HashMap<>();
        for (int i = 0;i<str1.length();i++){
            data.put(str1.charAt(i), data.getOrDefault(str1.charAt(i),0) + 1);
        }

        for (int i = 0;i<str2.length();i++){
            if(data.containsKey(str2.charAt(i))){
                if(data.get(str2.charAt(i)) <= 0){
                    return false;
                }else{
                    data.put(str2.charAt(i), data.get(str2.charAt(i)) - 1);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
