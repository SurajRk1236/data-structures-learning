package org.learning.dsa.patterns.sliding_window;
import java.util.*;

public class RepeatedDnaSequence187 {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> sequenceCount = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String sequence = s.substring(i, i + 10);
            sequenceCount.put(sequence, sequenceCount.getOrDefault(sequence, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : sequenceCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
