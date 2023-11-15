package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.BADGE;
import christmas.domain.MENU;
import christmas.service.Calculate;
import christmas.view.InputViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Map;

public class CalculateTest {
    InputViewer inputViewer = new InputViewer();

    @DisplayName("주문한 메뉴 총 계산값 테스트")
    @Test
    void 할인전_금액_계산() {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        int expectPrice = 142_000;
        //142,000원
        int price = new Calculate().totalPrice(inputViewer.parseMenu(input));
        assertThat(price).isEqualTo(expectPrice);
    }

    @Test
    void 뱃지_정상_출력() {
        int discountPrice = 10_000;
        String expectBadge = "트리";
        String badge = BADGE.getBadge(discountPrice, discountPrice).getGrade();
        assertThat(badge).isEqualTo(expectBadge);
    }

    @Test
    void 샴페인_증정_유무() {
        int total_money = 12_0000;
        String expect = MENU.CHAMPAGNE.getName();
        assertThat(expect).isEqualTo((new Calculate().hasChampagne(total_money)).getName());
    }

    @Test
    void 평일_디저트_메뉴_확인() {
        String input = "바비큐립-1,초코케이크-2,제로콜라-1";
        int expect_price= 2023*2;
        Map<String, String> menu = inputViewer.parseMenu(input);
        assertThat(expect_price).isEqualTo(new Calculate().weekdayDiscount(menu));
    }
    @Test
    void 주말_메인_메뉴_확인() {
        String input = "티본스테이크-4,바비큐립-1,초코케이크-2,제로콜라-1";
        int expect_price= 2023*5;
        Map<String, String> menu = inputViewer.parseMenu(input);
        assertThat(expect_price).isEqualTo(new Calculate().weekendDiscount(menu));
    }
}
