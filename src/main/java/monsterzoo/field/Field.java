package monsterzoo.field;

import java.util.Random;

public class Field extends GameContinueFlag{
    private Random random = new Random();
    private MessageQueue queue = new MessageQueue();

    public RandomValue next(){
        return next(10);
    }

    public RandomValue next(int max){
        return new RandomValue(random.nextInt(max));
    }

    public void flushMessage(){
        queue.println();
    }

    public void addMessage(Message message){
        queue.add(message);
    }

    public void addMessage(String message){
        this.addMessage(new Message(message));
    }
}
