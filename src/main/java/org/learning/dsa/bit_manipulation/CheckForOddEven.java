package org.learning.dsa.bit_manipulation;

public class CheckForOddEven {
    public static void main(String[] args) {
        System.out.println(checkOddEven(4));
    }

    private static boolean checkOddEven(int num) {
        return (num & 1) == 0;
    }
}
