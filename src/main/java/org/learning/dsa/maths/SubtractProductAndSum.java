package org.learning.dsa.maths;

public class SubtractProductAndSum {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(4421));
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int product =1;
        while(n>0){
            int remainder = n % 10;
            sum += remainder;
            product *= remainder;
            n = n/10;
        }
        return product - sum;
    }
}
