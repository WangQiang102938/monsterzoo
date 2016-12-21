package monsterzoo.field;

import java.util.Random;

public class Field extends GameContinueFlag{
    private Random random = new Random();
    private MessageCenter queue = new MessageCenter();

    public RandomValue next(){
        return next(10);
    }

    public RandomValue next(int max){
        return new RandomValue(random.nextInt(max));
    }

    public void flushMessage(){
        queue.println();
    }

    public void pushMessage(Message message){
        queue.add(message);
    }

    public void addMessage(String message){
        this.pushMessage(new Message(message));
    }
}
