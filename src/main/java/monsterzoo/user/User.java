package monsterzoo.user;

import static monsterzoo.user.Goods.BALL;

import java.util.function.Consumer;

import monsterzoo.Name;
import monsterzoo.field.Distance;
import monsterzoo.field.Message;
import monsterzoo.monster.Monster;
import monsterzoo.monster.Monsters;

public class User {
    private Bag bag = new Bag();
    private Monsters monsters = new Monsters();

    public User(){
        bag.add(BALL, new Count(10));
    }

    public void add(Egg egg){
        bag.add(egg);
    }

    public void add(Monster monster){
        monsters.register(monster);
    }

    public void add(Name name, Count count){
        bag.add(name, count);
    }

    public boolean hasGoods(Name name){
        return bag.hasGoods(name);
    }

    public void eachMonster(Consumer<Monster> consumer){
        monsters.forEach(consumer);
    }

    public void registerGoodsEmptyListener(GoodsEmptyListener listener){
        bag.register(listener);
    }

    public void registerIncubatoinListener(IncubationListener listener){
        bag.register(listener);
    }

    public Message statusMessage(){
        return bag.goodsStatusMessage();
    }

    public boolean use(Name name){
        return bag.use(name);
    }

    public Distance walk(Distance distance){
        bag.forEggs(
                egg -> egg.walk(distance));
        return distance;
    }
}
