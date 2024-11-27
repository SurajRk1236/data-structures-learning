package org.learning.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces547 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int v = isConnected.length;
            boolean[] visited = new boolean[v];
            List<List<Integer>> list = getListBasedOnArray(isConnected);
            int noOfProvinces = 0;
            for(int i = 0; i < v; i++){
                if(!visited[i]){
                    noOfProvinces++;
                    visited[i] = true;
                    dfs(i, list, visited);
                }
            }
            return noOfProvinces;
        }
        private void dfs(int j, List<List<Integer>> list, boolean[] visited){
            List<Integer> values = list.get(j);
            int n = values.size();
            for(int i = 0; i < n; i++){
                int currentValue = values.get(i);
                if(!visited[currentValue]){
                    visited[currentValue] = true;
                    dfs(i, list, visited);
                }
            }
        }
        private List<List<Integer>> getListBasedOnArray(int[][] isConnected){
            int row = isConnected.length;
            int col = isConnected[0].length;
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < row; i++){
                List<Integer> valueList = new ArrayList<>();
                for(int j = 0; j < col; j++){
                    if(i != j && isConnected[i][j] == 1){
                        valueList.add(j);
                    }
                }
                list.add(valueList);
            }
            return list;
        }
    }
}
