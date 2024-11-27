package org.learning.dsa.arrays;

public class CarPooling1094 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            // Create an array to hold passenger changes at each location.
            // Since the locations can go up to 1000, we initialize an array of size 1001.
            int[] passengerChanges = new int[1001];

            // Iterate over each trip and update the difference array.
            for (int[] trip : trips) {
                int numPassengers = trip[0];
                int from = trip[1];
                int to = trip[2];

                // Add passengers at the starting location.
                passengerChanges[from] += numPassengers;

                // Subtract passengers at the drop-off location.
                passengerChanges[to] -= numPassengers;
            }

            // Calculate the cumulative sum to get the number of passengers at each location.
            int currentPassengers = 0;
            for (int i = 0; i < 1001; i++) {
                currentPassengers += passengerChanges[i];

                // If at any point the number of passengers exceeds the capacity, return false.
                if (currentPassengers > capacity) {
                    return false;
                }
            }

            // If we never exceed the capacity, return true.
            return true;
        }
    }
}
