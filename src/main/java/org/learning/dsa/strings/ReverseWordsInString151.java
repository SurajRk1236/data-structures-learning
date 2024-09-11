package org.learning.dsa.strings;

public class ReverseWordsInString151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] data = s.split(" ");
        for (int i = data.length - 1; i >= 0; i--) {
            if (!data[i].isEmpty()) {
                result.append(data[i]).append(" ");
            }
        }
        return result.toString().trim();
    }
}
