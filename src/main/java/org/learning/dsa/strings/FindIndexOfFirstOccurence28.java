package org.learning.dsa.strings;

import java.util.Stack;

public class FindIndexOfFirstOccurence28 {
    public static void main(String[] args) {
        System.out.println(strStr("leetcode","leeto"));
    }
    public  static int strStr(String haystack, String needle) {
        // Special case: if needle is empty, return 0
        if (needle.isEmpty()) {
            return 0;
        }

        // Lengths of haystack and needle
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        // Traverse the haystack up to haystackLen - needleLen + 1
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            // Check if the substring of haystack starting from i matches needle
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i;  // Found the match, return the index
            }
        }

        // If no match found, return -1
        return -1;
    }
}
