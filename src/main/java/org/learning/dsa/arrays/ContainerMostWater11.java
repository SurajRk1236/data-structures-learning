package org.learning.dsa.arrays;

/**
 * This is basically to find the max area of water to be stored
 * start with two pointers
 * take the min of the pointers and multiply with the distance b/n two pointer
 * take the max of current and previous sum
 * then which pointer is minimum move the to right or left.
 */

public class ContainerMostWater11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int sum = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            sum = Math.max(sum, area);
            if (height[l] < height[r]) {
                l++;
            } else
                r--;
        }
        return sum;
    }
}
