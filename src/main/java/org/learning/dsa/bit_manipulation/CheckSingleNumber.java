package org.learning.dsa.bit_manipulation;

public class CheckSingleNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 3, 5, 5, 8, 8};
        System.out.println(checkSingleNumber(arr));
    }

    private static int checkSingleNumber(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }
        return ans;
    }
}
