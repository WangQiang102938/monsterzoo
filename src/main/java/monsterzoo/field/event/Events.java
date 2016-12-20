package monsterzoo.field.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import monsterzoo.field.MonsterZooField;
import monsterzoo.field.RandomValue;
import monsterzoo.user.User;

public class Events implements Event{
    private List<Event> events = new ArrayList<>();

    public Events(){
        register(new BattleEvent());
        register(new ZooStationEvent());
    }

    public void register(Event event){
        events.add(event);
    }

    @Override
    public void perform(MonsterZooField field, User user) {
        RandomValue value = field.next();
        performImpl(value, field, user);
    }

    private void performImpl(RandomValue value, MonsterZooField field, User user){
        Optional<Event> optionalEvent = chooseEvent(value, field, user);
        optionalEvent.ifPresent(
                event -> event.perform(field, user));
    }

    private Optional<Event> chooseEvent(RandomValue value, MonsterZooField field, User user){
        return events.stream()
                .filter(event -> event.accept(value))
                .reduce((before, after) -> before);
    }

    @Override
    public boolean accept(RandomValue value) {
        return true;
    }
}
