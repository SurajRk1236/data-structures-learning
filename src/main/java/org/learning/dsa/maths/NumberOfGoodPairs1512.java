package org.learning.dsa.maths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfGoodPairs1512 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(numIdenticalPairs(arr));

    }

    public static int numIdenticalPairs(int[] nums) {
        int sum = 0;
        int length = nums.length;
        Map<Integer, ArrayList<Integer>> mapped = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (mapped.containsKey(num)) {
                mapped.get(num).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                mapped.put(num, list);
            }
        }

        for (List<Integer> values : mapped.values()) {
            if (values.size() > 1)
                sum += getFactorial(values.size() - 1);
        }
        return sum;
    }

    private static int getFactorial(int size) {
        int sum = 0;
        while (size > 0) {
            sum += size;
            size--;
        }
        return sum;
    }
}
