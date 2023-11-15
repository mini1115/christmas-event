package christmas;


import christmas.controller.OrderController;
import christmas.view.Input;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        OrderController controller = new OrderController();
        controller.run();
    }
}
