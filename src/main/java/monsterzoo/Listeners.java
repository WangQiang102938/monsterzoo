package monsterzoo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Listeners<T> {
    private List<T> listeners = new ArrayList<T>();

    public void register(T listener){
        listeners.add(listener);
    }

    public void remove(T listener){
        listeners.remove(listener);
    }

    /**
     * listeners.fire(source, (listener, source) -> listener.event(source));
     */
    public <E> void fire(E source, BiConsumer<T, E> action){
        listeners.forEach(
                item -> action.accept(item, source));
    }
}
