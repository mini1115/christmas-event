package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum DAY {
    WEEKEND(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30), "주말"),
    SPECIAL(Arrays.asList(3, 10, 17, 24, 25, 31), "특별일"),
    //    CHRIRSTMAS(Arrays.asList(25),"크리스마스"),
    OTHER(Arrays.asList(0), "평일");

    private List<Integer> days;
    private String dayName;

    DAY(List<Integer> days, String dayName) {
        this.days = days;
        this.dayName = dayName;
    }

    public List<Integer> getDays() {
        return this.days;
    }

    public String getDayName() {
        return this.dayName;
    }

    public static DAY getDay(int day) {
        return Arrays.stream(DAY.values()).filter(x -> x.days.contains(day)).findAny().orElse(OTHER);
    }

    public static String getDayName(int day) {
        return getDay(day).getDayName();
    }

}
