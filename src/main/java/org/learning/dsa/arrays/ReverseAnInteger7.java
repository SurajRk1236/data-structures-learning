package org.learning.dsa.arrays;

public class ReverseAnInteger7 {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        boolean sign = x > 0;
        x= Math.abs(x);
        StringBuilder data = new StringBuilder();
        while (x > 0) {
            data.append(x % 10);
            x /= 10;
        }
        int parsed = Integer.parseInt(data.toString());
        return sign ? parsed : parsed * -1;
    }
}
