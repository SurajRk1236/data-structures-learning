package org.learning.dsa.maths;

public class RectangleArea223 {
    public static void main(String[] args) {

    }

    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            // Area of rectangle A
            int areaA = (ax2 - ax1) * (ay2 - ay1);
            // Area of rectangle B
            int areaB = (bx2 - bx1) * (by2 - by1);

            // Overlap dimensions
            int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
            int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

            // Overlap area
            int overlapArea = overlapWidth * overlapHeight;

            // Total area
            return areaA + areaB - overlapArea;
        }
    }
}
