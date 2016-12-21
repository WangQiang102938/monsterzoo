package monsterzoo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import monsterzoo.Listeners;

public class Eggs extends Listeners<IncubationListener> {
    private List<Egg> eggs = new ArrayList<>();

    public void add(Egg egg) {
        if (eggs.size() < 9)
            eggs.add(egg);
    }

    public void remove(Egg egg) {
        eggs.remove(egg);
    }

    public void each(Consumer<Egg> consumer) {
        eggs.forEach(consumer);
        checkIncubation();
        removeIncubated();
    }

    private void removeIncubated() {
        eggs.removeIf(egg -> egg.isIncubated());
    }

    private void checkIncubation() {
        eggs.stream()
        .filter(egg -> egg.isIncubated())
        .forEach(egg -> fireEvent(egg));
    }

    private void fireEvent(Egg egg) {
        fire(egg, (listener, incubatedEgg) -> listener.incubate(incubatedEgg));
    }
}
