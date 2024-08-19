package org.learning.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSumZeroSum {

    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{15, -2, 2, -8, 1, 7, 10, 23}));
    }

    private static int maxLen(int[] input) {
        int sum = 0;
        int maxlength = 0;
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (sum == 0)
                maxlength = i + 1;
            if (data.containsKey(sum))
                maxlength = Math.max(maxlength, i - data.get(sum));
            else
                data.put(sum, i);
        }
        return maxlength;
    }
}
