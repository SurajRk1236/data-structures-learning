package org.learning.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Nqueens51 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result  = new ArrayList<>();
        char[][] data = new char[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                data[i][j] = '.';
            }
        }

        helper(result,data,0,n);
        return result;
    }
    private static List<String> convertData(char[][] data){
        List<String> result = new ArrayList<>();

        for (char[] datum : data) {
            StringBuilder sb = new StringBuilder();
            for (char c : datum) {
                sb.append(c);
            }
            result.add(sb.toString());
        }

        return result;
    }

    private static void helper(List<List<String>> result, char[][] data, int row, int n){
        if(row==n){
            result.add(convertData(data));
            return;
        }

        for(int col=0;col<n;col++){
            if(isValid(row,col,data)){
                data[row][col] = 'Q';
                helper(result,data,row+1,n);
                data[row][col] = '.';
            }
        }
    }

    private static boolean isValid(int row, int col, char[][] data){
        for(int i=row;i>=0;i--){
            if(data[i][col] == 'Q'){
                return false;
            }
        }
        int diagnolCol = col;
        int diagnolCol2 = col;
        for(int i=row;i>=0;i--){
            if((diagnolCol >= 0 && data[i][diagnolCol] == 'Q') || (diagnolCol2 < data.length && data[i][diagnolCol2] == 'Q')){
                return false;
            }
            diagnolCol--;
            diagnolCol2++;
        }
        return true;
    }
}
