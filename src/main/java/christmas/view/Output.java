package christmas.view;

import christmas.domain.BADGE;
import christmas.domain.MENU;
import christmas.service.Calculate;
import christmas.service.Figure;

import java.text.DecimalFormat;
import java.util.Map;

public class Output {
    DecimalFormat df = new DecimalFormat("###,###");
    Figure figure = new Figure();
    Calculate calculate = new Calculate();
    private static int total_discount = 0;
    public void printMenu(Map<String, String> menu) {
        System.out.println("<주문 메뉴>");
        for (String key : menu.keySet()) {
            System.out.println(key + " " + menu.get(key) + "개");
        }
        System.out.println();
    }
    public void printBeforeDiscountMoney(int sum) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(df.format(sum) + "원");
    }
    public void showChristmas(int day) {
        int discount = 0;
        if (figure.beforeChristmas(day)) {
            discount = calculate.christmasDiscount(day);
            System.out.println("크리스마스 디데이 할인: -" + df.format(discount) + "원");
        }
        total_discount += discount;
    }

    public void showWeekend(int day, Map<String, String> menu) {
        int discount = 0;
        if (figure.weekendOrNot(day)) {
            discount += calculate.weekendDiscount(menu);
            System.out.println("주말 할인: -" + df.format(discount) + "원");
        }
        total_discount += discount;
    }

    public void showWeekday(int day, Map<String, String> menu) {
        int discount = 0;
        if (!figure.weekendOrNot(day)) {
            discount += calculate.weekdayDiscount(menu);
            System.out.println("평일 할인: -" + df.format(discount) + "원");
        }
        total_discount += discount;
    }

    public void showSpecial(int day) {
        if (figure.specialDayOrNot(day)) {
            total_discount += 1000;
            System.out.println("특별 할인: -" + df.format(1000) + "원");
        }
    }
}

