package org.learning.dsa.maths;

import java.util.Random;

public class Random10By7 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(rand10());
        }

    }

    public static int rand10() {
        return getRandomTill40() % 10 + 1;
    }

    private static int getRandomTill40() {
        int value = 7 * rand7() - (rand7() - 1);
        if (value > 40) {
            value = getRandomTill40();
        }
        return value;
    }

    private static int rand7() {
        return new Random().nextInt(1, 6);
    }
}
