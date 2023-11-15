package christmas.view;

import christmas.domain.BADGE;
import christmas.domain.MENU;
import christmas.service.Calculate;
import christmas.service.Figure;

import java.text.DecimalFormat;
import java.util.Map;

public class Output {
    DecimalFormat df = new DecimalFormat("###,###");
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
}

