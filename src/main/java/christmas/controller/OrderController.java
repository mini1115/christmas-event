package christmas.controller;

import christmas.service.Calculate;
import christmas.view.InputViewer;
import christmas.view.OutputViewer;

import java.util.Map;

public class OrderController {
    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;
    private final Calculate calculate;

    public OrderController() {
        this.inputViewer = new InputViewer();
        this.outputViewer = new OutputViewer();
        this.calculate = new Calculate();
    }

    public void run() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        int day = Integer.parseInt(inputViewer.readDate());
        Map<String, String> menu = inputViewer.readMenu();
        int sum = calculate.totalPrice(menu);
        outputViewer.showAll(menu, sum, day);
    }
}
