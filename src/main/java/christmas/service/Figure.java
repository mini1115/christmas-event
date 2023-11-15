package christmas.service;

import christmas.domain.DAY;

public class Figure {
    private static final int CHRISTMAS_DAY = 25;

    public String figureDay(int day) {
        return DAY.getDayName(day);
    }

    public boolean beforeChristmas(int day) {
        return (CHRISTMAS_DAY >= day);
    }

    public boolean weekendOrNot(int day) {
        return DAY.getDayName(day).equals("주말");
    }

    public boolean specialDayOrNot(int day) {
        return DAY.getDayName(day).equals("특별일");
    }
}
