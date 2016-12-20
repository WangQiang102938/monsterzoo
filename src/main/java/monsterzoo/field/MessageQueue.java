package monsterzoo.field;

import java.util.ArrayList;
import java.util.List;

public class MessageQueue {
    private List<Message> queue = new ArrayList<>();

    public void add(Message message){
        queue.add(message);
    }

    public void println(){
        List<Message> items = refresh();
        items.forEach(
                message -> message.println());
    }

    private List<Message> refresh(){
        List<Message> list = queue;
        queue = new ArrayList<>();
        return list;
    }
}
