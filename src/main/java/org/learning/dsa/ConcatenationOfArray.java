package org.learning.dsa;

import java.util.Arrays;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(getConcatenation(arr)));

    }

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] newArray = new int[n*2];

        for(int i =0 ;i<n;i++){
            newArray[i] = nums[i];
            newArray[n + i] = nums[i];
        }
        return newArray;
    }
}
