package christmas.error;

import christmas.domain.MENUKIND;
import christmas.domain.MENU;

import java.util.Map;

public class ErrorValidate {
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;

    public static void inputDayLimit(String day) {
        int days = Integer.parseInt(day);
        if (days < MIN_DAY || days > MAX_DAY) {
            throw new IllegalArgumentException();
        }
    }
}
