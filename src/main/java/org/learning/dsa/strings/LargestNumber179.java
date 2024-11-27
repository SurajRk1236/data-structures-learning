package org.learning.dsa.strings;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public static String largestNumber(int[] nums) {
        // Convert the numbers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to sort the numbers based on string concatenation
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                // Sort in descending order
                return order2.compareTo(order1);
            }
        });

        // If the largest number is "0", return "0" (handle case like [0, 0])
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Join the numbers to form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }
}
