package org.learning.dsa.recursion;

public class MultiplyWhithoutOperator {
    public static void main(String[] args) {
        System.out.println(mutilpy(5, 6));
    }

    private static int mutilpy(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return a > b ? checkvalue(a, b) : checkvalue(b, a);
    }

    private static int checkvalue(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a + checkvalue(a, b - 1);

    }
}
