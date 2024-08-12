package org.learning.dsa.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        helper(result, n);
        return result;
    }

    private static void helper(List<Integer> result, int n){
        if(n==0){
            result.add(0);
            return;
        }
        helper(result, n - 1);
        int currentSize = result.size();
        int mask = 1 << (n - 1);

        for (int i = currentSize - 1; i >= 0; i--) {
            result.add(result.get(i) | mask);
        }
    }


}
