package org.learning.dsa.maths;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
    public static int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum > 9) {
            return addDigits(sum);
        }
        return sum;
    }
}
