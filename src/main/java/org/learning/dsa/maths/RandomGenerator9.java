package org.learning.dsa.maths;

import java.util.Random;

public class RandomGenerator9 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generateRandom9());
        }

    }

    private static int generateRandom9() {
        return ((6 * random6() - (random6() - 1)) % 9) + 1;
    }

    private static int random6() {
        return new Random().nextInt(1, 6);
    }
}
