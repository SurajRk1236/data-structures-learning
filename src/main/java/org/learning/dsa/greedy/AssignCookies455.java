package org.learning.dsa.greedy;

import java.util.Arrays;

public class AssignCookies455 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int assignCookies = 0;
            int start = 0;
            int greedStart = 0;
            while(start < s.length && greedStart < g.length){
                if(s[start] >= g[greedStart]){
                    greedStart++;
                }
                start++;
            }
            return greedStart;
        }
    }
}
