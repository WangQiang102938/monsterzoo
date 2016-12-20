package monsterzoo.field.event;

import static monsterzoo.user.Goods.BALL;
import static monsterzoo.user.Goods.FRUITE;

import monsterzoo.Name;
import monsterzoo.field.Message;
import monsterzoo.field.MonsterZooField;
import monsterzoo.field.RandomValue;
import monsterzoo.monster.Monster;
import monsterzoo.monster.Rarity;
import monsterzoo.user.User;

public class Battle {
    private MonsterZooField field;
    private User user;

    public Battle(MonsterZooField field, User user){
        this.field = field;
        this.user = user;
    }

    public void start(Monster monster){
        boolean flag = turn(monster);
        flag = flag || turn(monster);
        flag = flag || turn(monster);
    }

    private boolean turn(Monster monster){
        Rarity rarity = drawLots();
        use(BALL, new Message(monster + "にボールを投げた．"));
        return catchMonster(monster, rarity);
    }

    private boolean catchMonster(Monster monster, Rarity rarity){
        boolean flag = monster.isCatchable(rarity);
        checkGotta(monster, user, flag);
        return flag;
    }

    private void checkGotta(Monster monster, User user, boolean flag){
        if(flag) user.add(monster);
        field.addMessage(monster + (flag? "を捕まえた！": "に逃げられた！"));
    }

    private Rarity drawLots(){
        int bonus = use(FRUITE, new Message("フルーツを投げた！捕まえやすさが倍になる！"));
        RandomValue value = field.next(6).times(bonus);
        return value.toRarity();
    }

    private int use(Name name, Message message){
        if(!user.hasGoods(name))
            return 1;
        return useImpl(name, message);
    }

    private int useImpl(Name name, Message message){
        field.addMessage(message);
        user.use(name);
        return 2;
    }
}
