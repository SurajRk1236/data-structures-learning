package org.learning.dsa.maths;

import java.util.Arrays;

public class SieveTheorm {
    public static void main(String[] args) {
        System.out.println(sieve(5));
    }

    private static boolean sieve(int n) {
        if (n < 2) {
            return false;
        }

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime[n]; // return whether n is prime or not
    }
}
