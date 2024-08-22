package org.learning.dsa.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairsSumExistsInArrayBoscoder {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{7, 8, 5, 9, 11}));
    }

    private static List<List<Integer>> solve(int[] arr) {
        Set<Integer> data = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            data.add(arr[i]);
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (data.contains(arr[i] + arr[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
