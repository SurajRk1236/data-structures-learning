package org.learning.dsa.greedy;

public class SplitStringToBalanced1221 {
    public static void main(String[] args) {

    }

    class Solution {
        public int balancedStringSplit(String s) {
            int count = 0, answer = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == 'R'){
                    count++;
                }else{
                    count--;
                }

                if(count == 0) answer++;
            }
            return answer;
        }
    }
}
