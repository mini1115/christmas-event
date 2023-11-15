package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ErrorTest extends NsTest {
    @DisplayName("정상 작동 출력")
    @Test
    void 모든_내용_정상_출력() {
        assertSimpleTest(() -> {
            run("25", "티본스테이크-1,바비큐립-1,초코케이크-3,아이스크림-2,제로콜라-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "티본스테이크 1개",
                    "제로콜라 1개",
                    "아이스크림 2개",
                    "초코케이크 3개",
                    "바비큐립 1개",
                    "<할인 전 총주문 금액>",
                    "167,000원",
                    "<증정 메뉴>",
                    "샴페인 1개",
                    "<혜택 내역>",
                    "크리스마스 디데이 할인: -3,400원",
                    "평일 할인: -10,115원",
                    "특별 할인: -1,000원",
                    "증정 이벤트: -25,000원",
                    "<총혜택 금액>",
                    "-39,515원",
                    "<할인 후 예상 결제 금액>",
                    "152,485원",
                    "<12월 이벤트 배지>",
                    "산타"
            );
        });
    }
    @DisplayName("입력한 값이 1~31 이외의 값일 경우 예외가 발생한다.")
    @Test
    void 범위_밖_날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("32");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });    }
    @DisplayName("메뉴판이 이외의 주문을 한 경우 예외가 발생한다.")
    @Test
    void 메뉴_예외_테스트_1() {
        assertSimpleTest(() -> {
            runException("3", "해산물파스타-1,사이다-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    @DisplayName("메뉴의 갯수가 양의 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void 메뉴_예외_테스트_2() {
        assertSimpleTest(() -> {
            runException("13", "해산물파스타-0,레드와인-1,초코케이크-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    @DisplayName("중복된 메뉴를 주문받았을때 예외가 발생한다.")
    @Test
    void 메뉴_예외_테스트_3() {
        assertSimpleTest(() -> {
            runException("31", "시저샐러드-1,시저샐러드-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    @DisplayName("주문한 메뉴의 갯수가 20개가 초과될 경우 예외가 발생한다.")
    @Test
    void 메뉴_예외_테스트_4() {
        assertSimpleTest(() -> {
            runException("31", "해산물파스타-15,레드와인-8,초코케이크-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    @DisplayName("음료 메뉴만 주문할 경우 예외가 발생한다.")
    @Test
    void 메뉴_예외_테스트_5() {
        assertSimpleTest(() -> {
            runException("31", "레드와인-1,제로콜라-3,샴페인-2");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
