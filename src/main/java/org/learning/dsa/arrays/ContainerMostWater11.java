package org.learning.dsa.arrays;

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
