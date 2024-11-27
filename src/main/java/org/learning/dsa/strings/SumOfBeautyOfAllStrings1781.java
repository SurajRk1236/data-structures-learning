package org.learning.dsa.strings;

import java.util.HashMap;
import java.util.Map;
//
public class SumOfBeautyOfAllStrings1781 {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcbaa"));
    }
    public  static int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();

        // Step 1: Generate all substrings
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> frequencyMap = new HashMap<>();

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

                // Step 2: Calculate the beauty of the current substring
                totalBeauty += calculateBeauty(frequencyMap);
            }
        }

        return totalBeauty;
    }

    private  static int calculateBeauty(Map<Character, Integer> frequencyMap) {
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for (int freq : frequencyMap.values()) {
            if (freq > 0) {
                maxFreq = Math.max(maxFreq, freq);
                minFreq = Math.min(minFreq, freq);
            }
        }

        return maxFreq - minFreq;
    }
}
