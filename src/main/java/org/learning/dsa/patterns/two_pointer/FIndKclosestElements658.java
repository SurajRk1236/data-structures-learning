package org.learning.dsa.patterns.two_pointer;

import java.util.ArrayList;
import java.util.List;

//not undestood check properly
public class FIndKclosestElements658 {

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4,3));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        // Binary search to find the starting point of the k elements
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Extract the k elements
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
