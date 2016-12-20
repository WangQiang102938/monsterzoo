package monsterzoo.monster;

import monsterzoo.Name;

public class Monster {
    private Rarity rarity;
    private Name name;

    public Monster(Name name, Rarity rarity){
        this.name = name;
        this.rarity = rarity;
    }

    public boolean isCatchable(Rarity value){
        return value.compareTo(rarity) >= 0;
    }

    @Override
    public String toString(){
        return name.toString();
    }
}
