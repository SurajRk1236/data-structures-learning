package org.learning.dsa.heaps;

public class StrongPasswordChecker420 {
    public static void main(String[] args) {

    }

    class Solution {
        class PassWordChecker {
            String password;
            boolean isLower = false;
            boolean isUpper = false;
            boolean isDigit = false;
            boolean containsThreeRepeating = false;
            int charCount = 0;

            PassWordChecker(String pass) {
                password = pass;
            }

            void setLower(boolean data) {
                isLower = data;
            }

            void setDigit(boolean data) {
                isDigit = data;
            }

            void setUpper(boolean data) {
                isUpper = data;
            }

            void setRepeating(boolean data) {
                containsThreeRepeating = data;
            }

            void setCharCount(int data) {
                charCount = data;
            }

        }

        public int strongPasswordChecker(String password) {
            PassWordChecker passWordChecker = new PassWordChecker(password);
            int checkRepeat = 0;
            char previous = 0;
            int countLetters = 0;
            for(int i = 0; i < password.length(); i++){
                countLetters++;
                if(password.charAt(i) == previous){
                    checkRepeat++;
                }else{
                    checkRepeat = 0;
                }
                if(checkRepeat == 3){
                    passWordChecker.setRepeating(true);
                }

                if(Character.isUpperCase(password.charAt(i))){
                    passWordChecker.setUpper(true);
                }else if(Character.isDigit(password.charAt(i))){
                    passWordChecker.setDigit(true);
                }else if(Character.isLowerCase(password.charAt(i))){
                    passWordChecker.setLower(true);
                }

            }
            passWordChecker.setCharCount(countLetters);
            int answer = 0;
            if(!passWordChecker.containsThreeRepeating){
                answer++;
            }
            if(!passWordChecker.isDigit){
                answer++;
            }
            if(!passWordChecker.isUpper){
                answer++;
            }
            if(!passWordChecker.isLower){
                answer++;
            }

            if(countLetters < 6){
                answer += 6 - countLetters;
            }else if(countLetters > 20){
                answer += countLetters - 20;
            }

            return answer;
        }
    }
}
