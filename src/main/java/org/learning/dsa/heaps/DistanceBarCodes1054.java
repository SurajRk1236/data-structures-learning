package org.learning.dsa.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistanceBarCodes1054 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : barcodes){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                pq.offer(entry);
            }
            int[] result = new int[barcodes.length];
            int i = 0;
            while(pq.size() > 1){
                Map.Entry<Integer, Integer> firstEntry = pq.poll();
                Map.Entry<Integer, Integer> secondEntry = pq.poll();
                result[i] = firstEntry.getKey();
                result[i + 1] = secondEntry.getKey();
                firstEntry.setValue(firstEntry.getValue() - 1);
                secondEntry.setValue(secondEntry.getValue() - 1);

                if(firstEntry.getValue() > 0){
                    pq.offer(firstEntry);
                }
                if(secondEntry.getValue() > 0){
                    pq.offer(secondEntry);
                }
                i = i + 2;
            }

            while(!pq.isEmpty()){
                result[i] = pq.poll().getKey();
            }
            return result;
        }
    }
}
