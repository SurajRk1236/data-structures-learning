package org.learning.dsa.binary_search;

public class FindNthSquareRootGFG {
    public static void main(String[] args) {
        System.out.println(findNthSquareRoot(3));
    }

    public static double findNthSquareRoot(int x) {
        if (x == 0 || x == 1) return x;

        double start = 0, end = x, mid = 0;
        double precision = 1e-6;  // Accuracy level

        while ((end - start) > precision) {
            mid = (start + end) / 2;
            double square = mid * mid;

            if (square == x) return mid;
            else if (square < x) start = mid;
            else end = mid;
        }

        return mid;
    }
}
