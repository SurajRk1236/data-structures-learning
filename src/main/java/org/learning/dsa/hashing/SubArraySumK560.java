package org.learning.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> data = new HashMap<>();
        data.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (data.containsKey(sum - k)) {
                count+= data.get(sum - k);
            }
            data.put(sum, data.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
