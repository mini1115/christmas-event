package christmas;

import java.util.Map;
import java.util.Set;

public class Judgement {
    public int totalPrice(Map<String,String> menu){
        int sum = 0;
        //전체 메뉴 계산 메소드
        for (String key : menu.keySet()) {
            System.out.println(getDishPrice(key)+":"+key+":"+menu.get(key));
            sum+=getDishPrice(key)*Integer.parseInt(menu.get(key));
        }
        return sum;
    }
    public int getDishPrice(String dish){
        return MENU.getMenuPrice(dish).getPrice();
    }

}
