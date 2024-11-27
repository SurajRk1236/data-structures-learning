package org.learning.dsa.greedy;

import java.util.Arrays;
import java.util.Collections;

public class NonOverlappingIntervals435 {
    public static void main(String[] args) {

    }

    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
            int previous = -1;
            int answer = 0;
            for(int[] nums : intervals){
                int start = nums[0];
                int end = nums[1];
                if(previous > start) answer++;
                previous = end;
            }
            return answer;
        }
    }
}
