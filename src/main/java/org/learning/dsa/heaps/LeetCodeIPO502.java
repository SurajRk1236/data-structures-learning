package org.learning.dsa.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCodeIPO502 {
    public static void main(String[] args) {

    }

    class Solution {
        class Project{
            int profit;
            int capital;

            Project(int profit, int capital){
                this.profit = profit;
                this.capital = capital;
            }
        }
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = profits.length;
            Project[] arr = new Project[n];

            for(int i = 0; i < n; i++){
                arr[i] = new Project(profits[i], capital[i]);
            }
            Arrays.sort(arr, (a,b) -> a.capital - b.capital);

            PriorityQueue<Project> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);

            int i = 0;
            int maxProfit = 0;
            while(k > 0){
                while(i < n && capital[i] <= w){
                    pq.offer(new Project(profits[i], capital[i]));
                    i++;
                }

                if(!pq.isEmpty()){
                    Project proj = pq.poll();
                    w = proj.profit;
                    maxProfit += proj.profit;
                }
                k--;
            }
            return maxProfit;
        }
    }
}
