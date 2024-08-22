package org.learning.dsa.hashing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxPointOnLine149 {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(maxPoints(points));
    }

    private static int maxPoints(int[][] points) {
        if (points.length < 3) {
            return 2;
        }
        int maxPoints = 2;

        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, Integer> data = new HashMap<>();
            for (int j = i+1; j < points.length; j++) {
                if (i != j) {
                    int dx = points[j][0] - points[i][0];
                    int dy = points[j][1] - points[i][1];
                    Double slope = Math.atan2(dy, dx);
                    data.put(slope, data.getOrDefault(slope, 0) + 1);
                }
            }
            maxPoints = Math.max(maxPoints, Collections.max(data.values()) + 1);
        }
        return maxPoints;
    }
}
