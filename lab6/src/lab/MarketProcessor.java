package lab;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Best on 22.12.2015.
 */
public class MarketProcessor {
     Map goods = new HashMap<Good, Integer>();

    public void addGood(Good good, int quantity){
        if(goods.containsKey(good)){
            Integer goodInColQuantity = (Integer)goods.get(good);
            goodInColQuantity += quantity;
            goods.put(good, goodInColQuantity);
        }else{
            goods.put(good, quantity);
        }
    }
    public Map getBill(){
        return this.goods;
    }
}
