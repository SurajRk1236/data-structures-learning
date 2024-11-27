package org.learning.dsa.strings;

public class CheckBalancedString3340 {
    public static void main(String[] args) {
        System.out.println(isBalanced("1234"));
    }

        public static boolean isBalanced(String num) {

            if( num == null || num.isEmpty()) return false;
            int even = 0, odd = 0, n = num.length();
            for(int i = 0; i < n; i++){
                int currentDig = num.charAt(i) - '0';
                if(i % 2 == 0){
                    even += currentDig;
                }else{
                    odd += currentDig;
                }
            }
            return odd == even;
        }
}
