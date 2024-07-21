package org.learning.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm {
    public static void main(String[] args) {
        int[] num = {1, 2, 0, 0}; // Array form of integer
        int k = 34; // Integer to add
        int[] result = addToArrayForm(num, k);
        // Print the result
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int[] addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int n = num.length;
        int carry = 0;
        int i = n - 1;

        // Process from the least significant digit to the most significant digit
        while (i >= 0 || k > 0) {
            int x = (i >= 0) ? num[i] : 0;
            int y = k % 10;
            int sum = x + y + carry;

            result.add(sum % 10);
            carry = sum / 10;

            k /= 10;
            i--;
        }

        // If there's a remaining carry, add it
        if (carry > 0) {
            result.add(carry);
        }

        // Reverse the result to get the correct order
        Collections.reverse(result);

        // Convert List<Integer> to int[]
        int[] resultArray = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            resultArray[j] = result.get(j);
        }

        return resultArray;
    }
}
