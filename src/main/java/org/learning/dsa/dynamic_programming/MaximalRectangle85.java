package org.learning.dsa.dynamic_programming;

import java.util.Stack;

public class MaximalRectangle85 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[] prev = new int[col];
            int answer = Integer.MIN_VALUE;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(matrix[i][j] == '0'){
                        prev[j] = 0;
                    }else{
                        prev[j] = prev[j] + 1;
                    }
                }
                answer = Math.max(answer, getMaxHistogramArea(prev));
            }
            return answer;
        }

        private int getMaxHistogramArea(int[] arr){
            int n = arr.length;
            Stack<Integer> stack = new Stack<>();
            int ans = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                    int prev = stack.pop();
                    int area = arr[prev] * ((i - (stack.isEmpty() ? -1  : stack.peek())) - 1);
                    System.out.println(area);
                    ans = Math.max(ans, area);
                }
                stack.push(i);
            }

            while(!stack.isEmpty()){
                int prev = stack.pop();
                int area = arr[prev] * ((n - (stack.isEmpty() ? -1  : stack.peek())) - 1);
                System.out.println(area);
                ans = Math.max(ans, area);
            }
            return ans;
        }
    }
}
