package org.learning.dsa.binary_search;

public class NthRootBinarySearchGFG {

    public static double nthRoot(int n, double m, double precision) {
        double low = 0;
        double high = (m >= 1) ? m : 1;
        double mid;

        while ((high - low) > precision) {
            mid = (low + high) / 2;
            double midToNth = Math.pow(mid, n);

            if (Math.abs(midToNth - m) < precision) {
                return mid;  // Close enough to the nth root
            } else if (midToNth < m) {
                low = mid;  // Move right
            } else {
                high = mid; // Move left
            }
        }

        return (low + high) / 2; // Return the mid value after loop
    }

    public static void main(String[] args) {
        int n = 3;
        double m = 27;
        double precision = 1e-7;
        System.out.println("The " + n + "th root of " + m + " is: " + nthRoot(n, m, precision));
    }
}
