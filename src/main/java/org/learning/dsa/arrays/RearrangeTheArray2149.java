package org.learning.dsa.arrays;

import java.util.Arrays;
/**
 * This is regarding make all the negative in odd index and positive in even index
 *
 */

public class RearrangeTheArray2149 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3,1,-2,-5,2,-4})));
    }

    public static int[] rearrangeArray(int[] nums) {
        if (nums.length <= 1) return nums;
        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0;
        int negindex = 1;
        for (int num : nums) {
            if (num < 0) {
                result[negindex] = num;
                negindex += 2;
            } else {
                result[posIndex] = num;
                posIndex += 2;
            }
        }
        return result;
    }
}
