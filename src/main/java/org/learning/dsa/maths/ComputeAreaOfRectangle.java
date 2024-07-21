package org.learning.dsa.maths;

public class ComputeAreaOfRectangle {
    public static void main(String[] args) {
        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA1 = (ax2-ax1) * (ay2-ay1);
        int areaB1 = (bx2-bx1) * (by2-by1);

        int areaOverlap = 0;
        int length = (ay2-by2);
        int breadth = (ax2 - bx1);

        if(length > 0 && breadth>0)
            areaOverlap = breadth * length;

        return areaA1 + areaB1 - areaOverlap;

    }
}
