package org.learning.dsa.bit_manipulation;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(5)));
    }
    private static int[] solve(int n){
        int[] result = new int[n+1];
        for (int i = 0;i<=n; i++){
            result[i] = numberOfBits(i);
        }
        return result;
    }

    private static int numberOfBits(int n){
        int counter = 0;
        for(int i = 0;i<31;i++){
            if((n & (1<<i)) != 0 )
                counter++;
        }
        return counter;
    }
}
