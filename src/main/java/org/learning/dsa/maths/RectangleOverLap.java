package org.learning.dsa.maths;

public class RectangleOverLap {
    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[]{0,0,2,2},new int[]{1,1,3,3}));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];

        return x2 > x3 && x4 > x1 && y2 > y3 && y4 > y1;
    }
}
