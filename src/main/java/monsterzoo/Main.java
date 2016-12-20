package monsterzoo;

import monsterzoo.field.Distance;
import monsterzoo.field.MonsterZooField;
import monsterzoo.user.User;

public class Main {
    private static final long DEFAULT_SLEEP = 1000;

    public Main() throws InterruptedException{
        run(new MonsterZooField(), new User());
    }

    private void run(MonsterZooField field, User user) throws InterruptedException{
        field.initialize(user);
        explorer(field, user, new Distance(0));
        printResult(field, user);
    }

    private void explorer(MonsterZooField field, User user, Distance distance) throws InterruptedException{
        while(field.isContinue())
            distance = move(field, user, distance);
    }

    private void printResult(MonsterZooField field, User user){
        addMessages(field, user);
        field.flushMessage();
    }

    private void addMessages(MonsterZooField field, User user){
        field.addMessage("ボールがなくなった！");
        user.eachMonster(
                monster -> field.addMessage(monster + "を捕まえた．"));
    }

    private Distance move(MonsterZooField field, User user, Distance distance) throws InterruptedException{
        field.flushMessage();
        Thread.sleep(DEFAULT_SLEEP);
        return field.move(user, distance);
    }

    public static void main(String[] args) throws InterruptedException{
        new Main();
    }
}
