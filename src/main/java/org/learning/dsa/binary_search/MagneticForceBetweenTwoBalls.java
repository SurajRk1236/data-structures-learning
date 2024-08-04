package org.learning.dsa.binary_search;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1,2,3,4,7}, 3));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = position[position.length - 1] - position[0];
        int result = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (condition(mid, position, m)) {
                result = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return result;
    }

    private static boolean condition(int mid, int[] position, int m) {
        int count = 1;
        int n = position.length;
        int previousIndex = 0;
        for (int i = 1; i < n; i++) {
            if (position[i] - position[previousIndex] >= mid) {
                count++;
                previousIndex = i;
            }
        }
        return count >= m;
    }
}
