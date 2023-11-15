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
    public static void hasMenu(Map<String, String> menu) {
        for (String key : menu.keySet()) {
            if (MENU.getMenuPrice(key).getName().equals("없는메뉴")) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void MenuNumZero(Map<String, String> menu) {
        for (String key : menu.keySet()) {
            if (menu.get(key).equals("0")) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void MaxOrderMenu(Map<String, String> menu) {
        int sum = 0;
        for (String key : menu.keySet()) {
            sum += Integer.parseInt(menu.get(key));
        }
        if (sum > 20) {
            throw new IllegalArgumentException();
        }
    }
    public static void onlyBeverageMenu(Map<String, String> menu) {
        boolean result = true;
        for (String key : menu.keySet()) {
            if (!MENUKIND.getDiscountMenu(key).getKind().equals("음료메뉴"))
                result = false;
            break;
        }
        if (result) {
            throw new IllegalArgumentException();
        }

    }
}
