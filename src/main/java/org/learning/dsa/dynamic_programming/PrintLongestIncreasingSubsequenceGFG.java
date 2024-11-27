package org.learning.dsa.dynamic_programming;

import java.util.Arrays;
import java.util.LinkedList;

public class PrintLongestIncreasingSubsequenceGFG {
    public static void main(String[] args) {
        System.out.println(getLongestIncreasingSubsequence(new int[]{5, 4, 11, 1, 16, 8}));
    }

    private static LinkedList<Integer> getLongestIncreasingSubsequence(int[] arr) {
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];
        Arrays.fill(dp, 1);
        Arrays.fill(hash, 1);
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            hash[i] = i;
            for (int j = 0 ; j < i; j++) {
                if(arr[i] > arr[j] && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(maxLength);
        int ans = -1;
        int lastIndex = -1;
        for(int i=0; i<arr.length; i++){
            if(dp[i]> ans){
                ans = dp[i];
                lastIndex = i;
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(arr[lastIndex]); // Start with the last element in the LIS
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list.addFirst(arr[lastIndex]);
        }

        return list;
    }
}
