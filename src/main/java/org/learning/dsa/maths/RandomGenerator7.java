package org.learning.dsa.maths;

import java.util.Random;

public class RandomGenerator7 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generateRandom9());
        }

    }

    private static int generateRandom9() {
        return (getRandomNumberTill20() % 7) + 1;
    }

    private static int getRandomNumberTill20() {
        int value = (5 * random5()) - (random5() - 1);
        if (value > 20) {
            value = getRandomNumberTill20();
        }
        return value;
    }

    private static int random5() {
        return new Random().nextInt(1, 6);
    }
}
