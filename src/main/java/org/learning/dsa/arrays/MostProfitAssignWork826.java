package org.learning.dsa.arrays;

import java.util.Arrays;

public class MostProfitAssignWork826 {
    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{2,4,6,8,10},new int[]{10,20,30,40,50},new int[]{4,5,6,7}));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        // Step 1: Create pairs of {difficulty, profit} and sort them by difficulty
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // Sort jobs by difficulty

        // Step 2: Sort workers by their ability
        Arrays.sort(worker);

        int maxProfit = 0;  // Total profit earned
        int maxSoFar = 0;   // Maximum profit up to the current difficulty
        int jobIndex = 0;   // Index to track jobs

        // Step 3: For each worker, assign the best possible job
        for (int ability : worker) {
            // Move jobIndex to the highest profit job the worker can handle
            while (jobIndex < n && jobs[jobIndex][0] <= ability) {
                maxSoFar = Math.max(maxSoFar, jobs[jobIndex][1]);
                jobIndex++;
            }
            // Add the best possible profit for this worker
            maxProfit += maxSoFar;
        }

        return maxProfit;  // Return the total maximum profit
    }
}
