package monsterzoo.field.event;

import static monsterzoo.user.Goods.BALL;
import static monsterzoo.user.Goods.FRUITE;

import monsterzoo.Name;
import monsterzoo.field.MonsterZooField;
import monsterzoo.field.RandomValue;
import monsterzoo.user.Egg;
import monsterzoo.user.User;

public class ZooStationEvent implements Event{
    @Override
    public boolean accept(RandomValue value){
        return value.compareTo(2) < 0;
    }

    @Override
    public void perform(MonsterZooField field, User user) {
        field.addMessage("ズーstationを見つけた！");
        performImpl(field, user);
    }

    private void performImpl(MonsterZooField field, User user){
        String message = String.format("ボールを%s個，フルーツを%s個，卵を%s個 Get した！",
                item(field, user, BALL, 3), item(field, user, FRUITE, 2), egg(field, user));
        field.addMessage(message);
    }

    private String item(MonsterZooField field, User user, Name name, int max){
        RandomValue value = field.next(max);
        user.add(name, value.toCount());
        return value.toString();
    }

    private String egg(MonsterZooField field, User user){
        RandomValue value = field.next(2);
        addEggs(field, user, value);
        return value.toString();
    }

    private void addEggs(MonsterZooField field, User user, RandomValue value){
        value.stream()
        .forEach(index -> addEgg(field, user, new Egg()));
    }

    private void addEgg(MonsterZooField field, User user, Egg egg){
        user.add(egg);
    }
}
