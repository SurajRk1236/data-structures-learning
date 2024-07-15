package org.learning.dsa.arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        int trap = trap(arr);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int start = 0;
        int end = height.length - 1;
        int sum = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                if (height[start] > leftMax) {
                    leftMax = height[start];
                } else
                    sum += leftMax - height[start];
                start++;
            } else {
                if (height[end] > rightMax) {
                    rightMax = height[end];
                } else
                    sum += rightMax - height[end];
                end--;
            }
        }
        return sum;
    }
}
