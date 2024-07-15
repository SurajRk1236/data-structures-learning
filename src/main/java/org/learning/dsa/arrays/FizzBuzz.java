package org.learning.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        List<String> requiredData = fizzBuzz(5);
        System.out.println(requiredData);
        List<String> requiredData1 = fizzBuzz(15);
        System.out.println(requiredData1);
    }

    private static List<String> fizzBuzz(int n) {
        List<String> requiredData = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                requiredData.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0)
                requiredData.add("Fizz");
            else if (i % 5 == 0)
                requiredData.add("Buzz");
            else
                requiredData.add(String.valueOf(i));
        }
        return requiredData;
    }
}