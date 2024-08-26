package org.learning.dsa.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin973 {
    public static void main(String[] args) {
        int[][] points =
                        {{1,3},
                        {-2,2}};
        System.out.println(Arrays.deepToString(kClosest(points, 1)));
    }

    public static int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
