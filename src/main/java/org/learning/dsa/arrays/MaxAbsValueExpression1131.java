package org.learning.dsa.arrays;

public class MaxAbsValueExpression1131 {
    public static void main(String[] args) {
        System.out.println(maxAbsValExprV2(new int[]{1,-2,-5,0,10}, new int[]{0,-2,-1,-7,-4}));
    }

    public static int maxAbsValExprV2(int[] arr1, int[] arr2) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE, min4 = Integer.MAX_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            max1 = Math.max(max1, arr1[i] + arr2[i] + i);
            min1 = Math.min(min1, arr1[i] + arr2[i] + i);

            max2 = Math.max(max2, arr1[i] + arr2[i] - i);
            min2 = Math.min(min2, arr1[i] + arr2[i] - i);

            max3 = Math.max(max3, arr1[i] - arr2[i] + i);
            min3 = Math.min(min3, arr1[i] - arr2[i] + i);

            max4 = Math.max(max4, arr1[i] - arr2[i] - i);
            min4 = Math.min(min4, arr1[i] - arr2[i] - i);
        }

        int result = Math.max(Math.max(max1 - min1, max2 - min2), Math.max(max3 - min3, max4 - min4));

        return result;
    }

    public static int maxAbsValExpr(int[] arr1, int[] arr2) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                sum = Math.max(sum, (Math.abs(arr1[i] - arr1[j])
                        + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j)));
            }
        }
        return sum;
    }
}
