package org.learning.dsa.maths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourDivisors {
    public static void main(String[] args) {
        System.out.println(sumFourDivisors(new int[]{21,4,7}));
    }

    public static int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            int max = (int) Math.sqrt(num);
            List<Integer> totalValues = new ArrayList<>();
            for (int i = 1; i <= max; i++) {
                if (num % i == 0) {
                    totalValues.add(i);
                    if (i != num / i)
                        totalValues.add(num / i);
                }
                if (totalValues.size() == 5) {
                    break;
                }
            }
            if (totalValues.size() == 4) {
                for (Integer value : totalValues) {
                    sum += value;
                }
            }
        }
        return sum;
    }
}
