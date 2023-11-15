package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.BADGE;
import christmas.service.Calculate;
import christmas.view.InputViewer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Base64;

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

}
