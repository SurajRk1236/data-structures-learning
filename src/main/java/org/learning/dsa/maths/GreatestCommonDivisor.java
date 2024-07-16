package org.learning.dsa.maths;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int[] required = new int[]{7,5,6,8,3};
        System.out.println(getGreatestCommonDivisor(required));
    }

    private static int getGreatestCommonDivisor(int[] nums) {
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for (int num : nums) {
            small = Math.min(small, num);
            large = Math.max(large, num);
        }
        while (large != 0) {
            int temp = large;
            large = small % large;
            small = temp;
        }
        return small;
    }
}
