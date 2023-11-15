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

    public int weekdayDiscount(Map<String, String> menu) {
        int count = 0;
        for (String key : menu.keySet()) {
            if (MENUKIND.getDiscountMenu(key).getKind().contains("디저트")) {
                count += Integer.parseInt(menu.get(key));
            }
        }
        return DISCOUNT_MENU * count;
    }

    public int weekendDiscount(Map<String, String> menu) {
        int count = 0;
        for (String key : menu.keySet()) {
            if (MENUKIND.getDiscountMenu(key).getKind().contains("메인")) {
                count += Integer.parseInt(menu.get(key));
            }
        }
        return DISCOUNT_MENU * count;
    }

    public int christmasDiscount(int day) {
        int discount = 0;
        discount = (day - 1) * 100 + 1000;
        //total+=discount;
        return discount;
    }

    public MENU hasChampagne(int sum) {
        if (sum >= FREE_CHAMPAGNE_LIMIT) {
            return MENU.CHAMPAGNE;
        }
        return MENU.EMPTY;
    }
}
