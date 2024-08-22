package org.learning.dsa.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequtiveSequence128 {
    public static void main(String[] args) {
        System.out.println(longestConsequetiveSeq(new int[]{100, 4, 200, 1, 3, 2}));
    }

    private static int longestConsequetiveSeq(int[] input) {
        Set<Integer> data = new HashSet<>();
        for (int num : input) {
            data.add(num);
        }
        int maxLength = 0;
        for (int num : input) {
            int current = 0;
            int currentnum = num;
            if (!data.contains(currentnum - 1)) {
                current++;


                while (data.contains(currentnum + 1)) {
                    current++;
                    currentnum += 1;
                }
                maxLength = Math.max(maxLength, current);
            }
        }
        return maxLength;
    }
}
