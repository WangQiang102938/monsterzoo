package monsterzoo.field.event;

import monsterzoo.field.MonsterZooField;
import monsterzoo.field.RandomValue;
import monsterzoo.monster.Monster;
import monsterzoo.user.User;

public class BattleEvent implements Event{
    @Override
    public boolean accept(RandomValue value){
        return value.compareTo(7) >= 0;
    }

    @Override
    public void perform(MonsterZooField field, User user) {
        Monster monster = encounter(field);
        Battle battle = new Battle(field, user);
        battle.start(monster);
    }

    private Monster encounter(MonsterZooField field){
        Monster monster = field.encounter();
        field.addMessage(monster + "が現れた！");
        return monster;
    }
}
