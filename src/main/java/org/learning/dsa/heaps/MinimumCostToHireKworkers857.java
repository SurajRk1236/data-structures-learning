package org.learning.dsa.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumCostToHireKworkers857 {
    public static void main(String[] args) {

    }

//    this solution is not correct
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int n = quality.length;
            double result = wage[0];
            PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> (int) (a[0] - b[0]));
            for(int i = 1; i < n; i++){
                pq.offer(new double[]{(double) quality[0] /quality[i], quality[i], wage[i]});
            }

            while(k > 0 && !pq.isEmpty()){
                double[] data = pq.poll();
                double ratio = data[0];
                double qualityPop = data[1];
                double wagePop = data[2];

                double valueToBeadded = ratio * wage[0];
                if(valueToBeadded >= wagePop){
                    result += valueToBeadded;
                    k--;
                }
            }

            return result;
        }
    }
}
