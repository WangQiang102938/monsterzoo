package monsterzoo.user;

import java.util.HashMap;
import java.util.Map;

import monsterzoo.Listeners;
import monsterzoo.Name;

public class Goods extends Listeners<GoodsEmptyListener>{
    public static Name BALL   = new Name("ボール");
    public static Name FRUITE = new Name("フルーツ");

    private Map<Name, Count> goods = new HashMap<>();

    public void add(Name name, Count additionalCount){
        Count count = goods.getOrDefault(name, new Count(0));
        Count newCount = count.add(additionalCount);
        goods.put(name, newCount);
    }

    public Count count(Name name){
        return goods.getOrDefault(name, new Count(0));
    }

    public boolean use(Name name){
        boolean flag = use(name, goods.get(name));
        fireEvent(flag, name);
        return flag;
    }

    private void fireEvent(boolean flag, Name name){
        if(flag)
            fire(name, (listener, source) -> listener.empty(source));
    }

    private boolean use(Name name, Count count){
        if(!hasNoGoods(name))
            useImpl(name, count);
        return hasNoGoods(name);
    }

    private void useImpl(Name name, Count count){
        Count newCount = count.decrement();
        goods.put(name, newCount);
    }

    public boolean hasNoGoods(Name name){
        Count count = goods.get(name);
        return count == null || count.isEmpty();
    }
}
