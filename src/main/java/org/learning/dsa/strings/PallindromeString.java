package org.learning.dsa.strings;

public class PallindromeString {
    public static void main(String[] args) {
        System.out.println(check("a"));
    }

    private static boolean check(String s){
        char[] allData = s.toCharArray();
        int left = 0;
        int right = allData.length - 1;
        while(left < right){
            if(allData[left] != allData[right])
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
