package monsterzoo.monster;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import monsterzoo.Name;

public class Monsters {
    List<Monster> monsters = new ArrayList<>();

    public Monsters(){
    }

    public void register(Name name, Rarity rarity){
        register(new Monster(name, rarity));
    }

    public void register(Monster monster){
        monsters.add(monster);
    }

    public void forEach(Consumer<Monster> consumer){
        monsters.stream()
        .forEach(consumer);
    }
}
