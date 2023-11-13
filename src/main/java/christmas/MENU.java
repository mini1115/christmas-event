package christmas;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum MENU {
    //에피타이저
    SOUP("양송이수프",6000),
    TAPAS("타파스",5500),
    SALAD("시저샐러드",8000),
    //메인메뉴
    STEAK("티본스테이크",55000),
    RIB("바비큐립",54000),
    SEAFOOD_PASTA("해산물파스타",35000),
    CHRISTMAS_PASTA("크리스마스파스타",25000),
    //디저트
    CAKE("초코케이크",15000),
    ICE_CREAM("아이스크림",5000),
    COKE("제로콜라",3000),
   //음료
    WINE("레드와인",60000),
    CHAMPAGNE("샴페인",25000),
    EMPTY("없는메뉴",0);
    private final String name;
    private final int price;

    MENU(String name,int price){
        this.name = name;
        this.price = price;
    }

    public static MENU getMenuPrice(String name){
        return Arrays.stream(MENU.values()).filter(x->x.name.equals(name)).findAny().orElse(EMPTY);
    }
    public int getPrice(){
        return this.price;
    }
}