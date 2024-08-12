package org.learning.dsa.patterns.two_pointer;

import java.util.Arrays;

public class TwoSumii167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                result[0] = l;
                result[1] = r;
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
