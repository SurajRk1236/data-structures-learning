package org.learning.dsa.strings;
/**
 * by heart this zelens formula
 */

public class DayOfWeekByHeart {
    public static void main(String[] args) {
        System.out.println(getDayOfWeek(19,7,2024));
    }

    public static String getDayOfWeek(int day, int month, int year) {
        if (month == 1 || month == 2) {
            month += 12;
            year -= 1;
        }

        int q = day;
        int m = month;
        int K = year % 100;
        int J = year / 100;

        int h = (q + (13 * (m + 1)) / 5 + K + K / 4 + J / 4 + 5 * J) % 7;

        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        return daysOfWeek[h];
    }
}
