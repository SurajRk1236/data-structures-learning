package org.learning.dsa.binary_search;

import java.util.Arrays;

public class FirstAndLastSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{}, 6)));
    }

    private static int[] solve(int[] input, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = input.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (input[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (input.length == 0 || target != input[left]) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        result[0] = left;
        int index = left;
        for (int i = left + 1; i < input.length; i++) {
            if (input[left] == input[i]) {
                index = i;
            } else
                break;
        }
        result[1] = index;
        return result;
    }
}
