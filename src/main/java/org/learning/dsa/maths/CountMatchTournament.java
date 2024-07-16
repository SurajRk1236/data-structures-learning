package org.learning.dsa.maths;

public class CountMatchTournament {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(14));
    }

    public static int numberOfMatches(int n) {
        int sum = 0;

        while (n > 1) {
            sum += n / 2;
            n = n % 2 == 0 ? n / 2 : n / 2 + 1;
        }
        return sum;
    }
}
