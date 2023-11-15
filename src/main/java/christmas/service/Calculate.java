package christmas.service;

import christmas.domain.MENU;
import christmas.domain.MENUKIND;

import java.util.Map;

public class Calculate {
    private static final int DISCOUNT_MENU = 2023;
    private static final int FREE_CHAMPAGNE_LIMIT = 120_000;

    public int totalPrice(Map<String, String> menu) {
        int sum = 0;
        for (String key : menu.keySet()) {
            sum += getDishPrice(key) * Integer.parseInt(menu.get(key));
        }
        return sum;
    }

    public int getDishPrice(String dish) {
        return MENU.getMenuPrice(dish).getPrice();
    }
    public MENU hasChampagne(int sum) {
        if (sum >= FREE_CHAMPAGNE_LIMIT) {
            return MENU.CHAMPAGNE;
        }
        return MENU.EMPTY;
    }
}
