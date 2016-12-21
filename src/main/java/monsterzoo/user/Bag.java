package monsterzoo.user;

import static monsterzoo.user.Goods.BALL;
import static monsterzoo.user.Goods.FRUITE;

import java.util.function.Consumer;

import monsterzoo.Name;
import monsterzoo.field.Message;

public class Bag {
    private Eggs eggs = new Eggs();
    private Goods goods = new Goods();

    public void add(Egg egg) {
        eggs.add(egg);
    }

    public void add(Name name, Count count) {
        goods.add(name, count);
    }

    public void forEggs(Consumer<Egg> consumer) {
        eggs.each(consumer);
    }

    public Message goodsStatusMessage() {
        return new Message(String.format("手持ちのボールは%s個，フルーツは%s個",
                goods.count(BALL),
                goods.count(FRUITE)));
    }

    public boolean hasGoods(Name name) {
        return !goods.hasNoGoods(name);
    }

    public void register(GoodsEmptyListener listener) {
        goods.register(listener);
    }

    public void register(IncubationListener listener) {
        eggs.register(listener);
    }

    public boolean use(Name name) {
        return goods.use(name);
    }
}
