package org.learning.dsa.greedy;

public class PartitionArrayInto3Parts1013 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean canThreePartsEqualSum(int[] arr) {
            int totalSum = 0;
            for (int num : arr) {
                totalSum += num;
            }

            // If total sum is not divisible by 3, we cannot partition the array
            if (totalSum % 3 != 0) {
                return false;
            }

            int targetSum = totalSum / 3;
            int currentSum = 0;
            int partsFound = 0;

            // Traverse through the array to find partitions
            for (int num : arr) {
                currentSum += num;

                // If we reach targetSum, reset currentSum and count a part
                if (currentSum == targetSum) {
                    partsFound++;
                    currentSum = 0;
                }

                // If we have found 3 parts, we can return true
                if (partsFound == 3) {
                    return true;
                }
            }

            // If fewer than 3 parts were found, return false
            return false;
        }
    }
}
