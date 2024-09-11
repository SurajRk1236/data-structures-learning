package org.learning.dsa.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> result = new Stack<>();
        String checkSymbol = "+-*/";
        for(String token : tokens){
            if(checkSymbol.contains(token)){
                int data1 = result.pop();
                int data2 = result.pop();
                result.push(getDataBasedOnSign(data1, data2, token));
            }else{
                result.push(Integer.parseInt(token));
            }
        }
        return result.peek();
    }

    private static int getDataBasedOnSign(int data1, int data2, String token ){
        return switch (token) {
            case "+" -> data1 + data2;
            case "-" -> data1 - data2;
            case "*" -> data1 * data2;
            case "/" -> data1 / data2;
            default -> 0;
        };
    }
}
