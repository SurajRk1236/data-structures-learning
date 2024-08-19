package org.learning.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInarray532 {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3,1,4,1,5},2));
    }

    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> data = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            data.put(num, data.getOrDefault(num, 0) + 1);
        }

        for (int num : data.keySet()) {

            if (k == 0) {
                if (data.get(num) > 1) {
                    count++;
                }
            } else {
                if (data.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
