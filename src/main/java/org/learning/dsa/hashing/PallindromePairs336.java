package org.learning.dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PallindromePairs336 {
    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        System.out.println(palindromePairs(words));
    }
    private static List<List<Integer>> palindromePairs(String[] words) {
        // Result list to store the pairs of indices
        List<List<Integer>> result = new ArrayList<>();

        // Map to store the reverse of each word as key and the index of the word as value
        Map<String, Integer> map = new HashMap<>();

        // Populate the map with the reverse of each word in the words array
        for (int i = 0; i < words.length; i++) {
            // Reverse the current word and store it in the map with its index
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        // Iterate through each word in the array to find possible palindrome pairs
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Split the word into two parts: left and right
            // Check for all possible splits from the start to the end of the word
            for (int j = 0; j <= word.length(); j++) {
                // Left part of the word
                String left = word.substring(0, j);
                // Right part of the word
                String right = word.substring(j);

                // Case 1: If the left part is a palindrome, check if there's a word in the map
                // that matches the right part and is not the same word (to avoid duplicates)
                if (isPalindrome(left) && map.containsKey(right) && map.get(right) != i) {
                    // Add the pair (index of reverse of right part, current word's index) to result
                    result.add(Arrays.asList(map.get(right), i));
                }

                // Case 2: If the right part is a palindrome, check if there's a word in the map
                // that matches the left part and is not the same word.
                // Ensure right.length() > 0 to avoid counting the same word twice.
                if (isPalindrome(right) && map.containsKey(left) && map.get(left) != i && right.length() > 0) {
                    // Add the pair (current word's index, index of reverse of left part) to result
                    result.add(Arrays.asList(i, map.get(left)));
                }
            }
        }
        return result;
    }
    // Helper method to check if a given string is a palindrome
    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        // Check if the characters at corresponding positions from the start and end match
        while (left < right) {
            // If any mismatch is found, the string is not a palindrome
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        // If all characters match, the string is a palindrome
        return true;
    }
}
