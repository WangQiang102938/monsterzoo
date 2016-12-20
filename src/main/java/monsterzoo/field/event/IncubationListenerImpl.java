package monsterzoo.field.event;

import monsterzoo.field.MonsterZooField;
import monsterzoo.monster.Monster;
import monsterzoo.user.Egg;
import monsterzoo.user.IncubationListener;
import monsterzoo.user.User;

public class IncubationListenerImpl implements IncubationListener{
    private MonsterZooField field;
    private User user;

    public IncubationListenerImpl(MonsterZooField field, User user){
        this.field = field;
        this.user = user;
    }

    @Override
    public void incubate(Egg egg) {
        incubate(field, field.encounter(), user);
    }

    private void incubate(MonsterZooField field, Monster monster, User user){
        field.addMessage("卵が孵った．");
        user.add(monster);
        field.addMessage(monster + "が産まれた．");
    }
}
