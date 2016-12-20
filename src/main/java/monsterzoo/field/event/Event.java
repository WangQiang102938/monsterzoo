package monsterzoo.field.event;

import monsterzoo.field.MonsterZooField;
import monsterzoo.field.RandomValue;
import monsterzoo.user.User;

public interface Event {
    void perform(MonsterZooField field, User user);

    boolean accept(RandomValue value);
}
