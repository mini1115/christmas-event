package christmas.controller;

import christmas.service.Calculate;
import christmas.view.Input;
import christmas.view.Output;

import java.util.Map;

public class OrderController {
    private final Input input;
    private final Output output;
    private final Calculate calculate;

    public OrderController() {
        this.input = new Input();
        this.output = new Output();
        this.calculate = new Calculate();
    }

    public void run() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        int day = Integer.parseInt(input.readDate());
        Map<String, String> menu = input.readMenu();
        int sum = calculate.totalPrice(menu);
        output.showAll(menu, sum, day);
    }
}
