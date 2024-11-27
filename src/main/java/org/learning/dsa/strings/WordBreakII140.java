package org.learning.dsa.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII140 {


    // HashMap to store the memoized results
    private static Map<String, List<String>> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cats", "dog", "catsand", "and", "dog")));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert list to set for faster lookups
        return backtrack(s, wordSet);
    }

    private static List<String> backtrack(String s, Set<String> wordSet) {
        // If we have already solved this substring, return the cached result
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        // If the entire string is a word, add it to the result
        if (wordSet.contains(s)) {
            result.add(s);
        }

        // Try breaking the string at every possible point
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            // If the left part is a valid word, recursively solve for the right part
            if (wordSet.contains(left)) {
                List<String> rightPartSentences = backtrack(right, wordSet);
                // Concatenate the left part with each sentence from the right part
                for (String sentence : rightPartSentences) {
                    result.add(left + " " + sentence);
                }
            }
        }

        // Memoize the result for this substring
        memo.put(s, result);
        return result;
    }
}
