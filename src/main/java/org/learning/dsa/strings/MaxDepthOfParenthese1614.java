package org.learning.dsa.strings;

public class MaxDepthOfParenthese1614 {
    public static void main(String[] args) {
        System.out.println(maxDepth("()(())((()()))"));
    }

    public static int maxDepth(String s) {
        int open = 0;
        int result = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                open ++;
            }else if( ch == ')'){
                result = Math.max(open, result);
                open--;
            }
        }
        return result;
    }
}
