package org.learning.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search2DMatrix {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 3, 5, 7));
        matrix.add(Arrays.asList(10, 11, 16, 20));
        matrix.add(Arrays.asList(23, 3, 34, 60));
        System.out.println(solve(matrix,30));
    }

    private static boolean solve(List<List<Integer>> input, int target) {
        int i = 0;
        int j = 0;
        int first = input.size() -1;
        int second = input.get(first - 1).size() -1;
        while (i <= first && second >= j) {
            if (input.get(i).get(second) > target) {
                second--;
            } else if (input.get(i).get(second) < target) {
                i++;
            } else
                return true;
        }
        return false;
    }
}
