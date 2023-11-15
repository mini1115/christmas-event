package christmas.domain;

import java.util.Arrays;

public enum MENUKIND {
    STEAK("티본스테이크","메인메뉴"),
    RIB("바비큐립","메인메뉴"),
    SEAFOOD_PASTA("해산물파스타","메인메뉴"),
    CHRISTMAS_PASTA("크리스마스파스타","메인메뉴"),
    //디저트
    CAKE("초코케이크","디저트메뉴"),
    ICE_CREAM("아이스크림","디저트메뉴"),
    COKE("제로콜라","음료메뉴"),
    //음료
    WINE("레드와인","음료메뉴"),
    CHAMPAGNE("샴페인","음료메뉴"),
    EMPTY("없는메뉴","비할인메뉴");


    private final String name;
    private final String kind;

    MENUKIND(String name, String kind){
        this.kind=kind;
        this.name=name;
    }

    public String getKind(){
        return this.kind;
    }
    public static MENUKIND getDiscountMenu(String name){
        return Arrays.stream(MENUKIND.values()).filter(x->x.name.equals(name)).findAny().orElse(EMPTY);

    }
}
