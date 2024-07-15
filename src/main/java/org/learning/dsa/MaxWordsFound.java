package org.learning.dsa;

public class MaxWordsFound {
    public static void main(String[] args) {
        String[] strings = new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(strings));
    }

    public static int mostWordsFound(String[] sentences) {
        int maxNumber = Integer.MIN_VALUE;
        for (String sentence : sentences) {
            maxNumber = Math.max(maxNumber, sentence.split(" ").length);
        }
        return maxNumber;
    }
}
