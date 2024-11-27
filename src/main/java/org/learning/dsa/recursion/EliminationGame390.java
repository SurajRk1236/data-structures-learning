package org.learning.dsa.recursion;

public class EliminationGame390 {
    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
    }
    public static int lastRemaining(int n) {
        return eliminationGame(n, true);
    }

    private static int eliminationGame(int n, boolean left) {
        // Base case: if there's only one element, return it
        if (n == 1) {
            return 1;
        }

        // If the round is from the left or if the remaining elements are odd,
        // the first element is removed
        if (left || n % 2 == 1) {
            return 2 * eliminationGame(n / 2, !left);
        } else {
            return 2 * eliminationGame(n / 2, !left) - 1;
        }
    }
}
