package christmas;

import christmas.service.Figure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
class FigureTest {
    @DisplayName("입력한 날짜가 크리스마스 이내라면 True 반환")
    @Test
    void 입력일_크리스마스_디데이_참_거짓_여부_반환1(){
        Figure figure = new Figure();
        int input_day =23;
        boolean value = figure.beforeChristmas(input_day);
        assertThat(value).isTrue();
    }
    @DisplayName("입력한 날짜가 크리스마스 이내라면 False 반환")
    @Test
    void 입력일_크리스마스_디데이_참_거짓_여부_반환2(){
        Figure figure = new Figure();
        int input_day =31;
        boolean value = figure.beforeChristmas(input_day);
        assertThat(value).isFalse();
    }
    @DisplayName("입력한 날짜가 주말이면 True 반환 기능")
    @Test
    void 입력일_주말_값_반환(){
        Figure figure = new Figure();
        int input_day =1;
        boolean value = figure.weekendOrNot(input_day);
        assertThat(value).isTrue();
    }
    @DisplayName("입력한 날짜가 평일이면 False 반환 기능")
    @Test
    void 입력일_평일_값_반환(){
        Figure figure = new Figure();
        int input_day =3;
        boolean value = figure.weekendOrNot(input_day);
        assertThat(value).isFalse();
    }
    @DisplayName("입력한 날짜가 특별일이면 True 반환 기능")
    @Test
    void 특별일_값_반환1(){
        Figure figure = new Figure();
        int input_day =25;
        boolean value = figure.specialDayOrNot(input_day);
        assertThat(value).isTrue();
    }
    @DisplayName("입력한 날짜가 특별일이 아니면 False 반환 기능")
    @Test
    void 특별일_값_반환2(){
        Figure figure = new Figure();
        int input_day =26;
        boolean value = figure.specialDayOrNot(input_day);
        assertThat(value).isFalse();
    }
}
