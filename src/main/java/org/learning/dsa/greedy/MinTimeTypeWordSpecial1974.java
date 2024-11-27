package org.learning.dsa.greedy;

public class MinTimeTypeWordSpecial1974 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minTimeToType(String word) {
            int time = 0;
            char currentPosition = 'a';

            for (char target : word.toCharArray()) {
                // Calculate clockwise and counterclockwise distances
                int clockwiseDist = (target - currentPosition + 26) % 26;
                int counterclockwiseDist = (currentPosition - target + 26) % 26;

                // Choose the minimum distance
                time += Math.min(clockwiseDist, counterclockwiseDist);
                time += 1; // Typing the character takes 1 second

                // Update the current position
                currentPosition = target;
            }

            return time;
        }
    }
}
