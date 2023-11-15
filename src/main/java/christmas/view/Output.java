package christmas.view;

import christmas.domain.BADGE;
import christmas.service.Calculate;
import christmas.service.Figure;

import java.text.DecimalFormat;
import java.util.Map;

public class Output {
    DecimalFormat df = new DecimalFormat("###,###");
    Figure figure = new Figure();
    Calculate calculate = new Calculate();
    private static int total_discount = 0;

    public void showAll(Map<String, String> menu, int sum, int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        printMenu(menu);
        printBeforeDiscountMoney(sum);
        int discount = showAllDiscount(menu, sum, day);
        discount += calculate.hasChampagne(sum).getPrice();
        showFreeChampagne(sum);
        showDiscountMoney(discount);
        printAfterDiscountMoney(sum, discount);
        showBadge(discount);
    }

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
        System.out.println("\n<증정 메뉴>");
        System.out.println(freeChampaign(sum));
    }

    public int showAllDiscount(Map<String, String> menu, int sum, int day) {
        System.out.println("\n<혜택 내역>");
        if (sum < 10000) {
            System.out.println("없음");
            return total_discount;
        }
        showChristmas(day);
        showWeekend(day, menu);
        showWeekday(day, menu);
        showSpecial(day);
        if (showFreeChampagne(sum)) {
            System.out.println("증정 이벤트: -25,000원");
        }
        return total_discount;
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

    public boolean showFreeChampagne(int sum) {
        return (calculate.hasChampagne(sum).getPrice() != 0);

    }

    public void showDiscountMoney(int money) {
        System.out.println("<총혜택 금액>\n" + df.format(money * -1) + "원");
    }

    public void printAfterDiscountMoney(int sum, int money) {
        System.out.println("<할인 후 예상 결제 금액>\n" +
                df.format(sum - money + calculate.hasChampagne(sum).getPrice()) + "원");
    }

    public void showBadge(int money) {
        String badge = BADGE.getBadge(money, money).getGrade();
        System.out.println("<12월 이벤트 배지>\n" + badge);
    }

    public String freeChampaign(int discount) {
        if (showFreeChampagne(discount)) {
            return "샴페인 1개";
        }
        return "없음";
    }
}

