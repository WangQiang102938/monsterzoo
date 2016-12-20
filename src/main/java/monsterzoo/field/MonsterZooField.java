package monsterzoo.field;

import monsterzoo.field.event.Events;
import monsterzoo.field.event.IncubationListenerImpl;
import monsterzoo.monster.Monster;
import monsterzoo.monster.MonsterDatabase;
import monsterzoo.user.User;

public class MonsterZooField extends Field{
    private static final Distance MOVEMENT_UNIT = new Distance(1.0);

    private MonsterDatabase db = new MonsterDatabase();
    private Events events = new Events();

    public void initialize(User user){
        user.registerGoodsEmptyListener(name -> empty(name));
        user.registerIncubatoinListener(new IncubationListenerImpl(this, user));
    }

    public Distance move(User user, Distance distance){
        performEvent(user);
        return postEvent(user, distance);
    }

    public Monster encounter(){
        return db.encounter(this);
    }

    private void performEvent(User user){
        events.perform(this, user);
    }

    private Distance postEvent(User user, Distance distance){
        distance = walk(user, distance);
        registerMessage(user, distance);
        return distance;
    }

    private Distance walk(User user, Distance distance){
        Distance otherDistance = user.walk(MOVEMENT_UNIT);
        return distance.add(otherDistance);
    }

    private void registerMessage(User user, Distance distance){
        addMessage(user.statusMessage());
        addMessage(distance + "km歩いた．");
    }
}
