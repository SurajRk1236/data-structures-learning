package org.learning.dsa.patterns.two_pointer;

public class ReverseString344 {
    public static void main(String[] args) {
        System.out.println(reverseString(new char[]{'h','e','l','l','o'}));
    }

    public static char[] reverseString(char[] s) {
        int start =0;
        int end = s.length -1;
        while(start<end){
            char temp = s[start];
            s[start] = s[end];
            s[end] =temp;
            start++;
            end--;
        }
        return s;
    }
}
