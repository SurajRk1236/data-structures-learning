package org.learning.dsa.hashing;

import java.util.HashMap;
import java.util.Map;
/**
 * First we will add all the chars from t string then we will check for substring in s
 * which has all chars from t by moving right pointer
 * if yes then reduce the window
 */


public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    private static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // Formed is used to keep track of how many unique characters in t
        // are present in the current window in their desired frequency.
        // e.g. if t is "AABC" then the window must have two 'A's, one 'B' and one 'C'.
        // Thus formed would be 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // If the frequency of the current character added equals to the desired count in t
            // then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
