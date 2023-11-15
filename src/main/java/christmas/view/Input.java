package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.error.ErrorMessage;
import christmas.error.ErrorValidate;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Input {
    public static String readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        try {
            ErrorValidate.inputDayLimit(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_DAY_LIMIT.getErrorMessage());
            return readDate();
        }
        return input;
    }

    public static Map<String, String> readMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        Map<String, String> orderMenu;
        try {
            orderMenu = parseMenu(input);
            ErrorValidate.hasMenu(orderMenu);
            ErrorValidate.MenuNumZero(orderMenu);
            ErrorValidate.MaxOrderMenu(orderMenu);
            ErrorValidate.onlyBeverageMenu(orderMenu);
        } catch (IllegalStateException e) {
            System.out.println(ErrorMessage.ERROR_MENU_FORMAT.getErrorMessage());
            return readMenu();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_ORDER_MENU.getErrorMessage());
            return readMenu();
        }
        return orderMenu;
    }

    public static Map<String, String> parseMenu(String input) {
        Map<String, String> menus;
        try {
            menus = Pattern.compile(",")
                    .splitAsStream(input.trim())
                    .map(i -> i.split("-"))
                    .collect(Collectors.toMap(a -> a[0], a -> a[1]));
            for (String key : menus.keySet()) {
                Integer.parseInt(menus.get(key));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(ErrorMessage.ERROR_MENU_FORMAT.getErrorMessage());
            return readMenu();
        }
        return menus;
    }

}

