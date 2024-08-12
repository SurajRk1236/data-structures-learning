package org.learning.dsa.sorting;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller315 {
    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5,2,6,1}));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }
}

