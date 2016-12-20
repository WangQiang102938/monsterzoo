package monsterzoo.monster;

import java.io.Serializable;

public class Rarity implements Serializable, Comparable<Rarity>{
    private static final long serialVersionUID = -1349355478760104672L;

    private int rarity;

    public Rarity(int rarity){
        this.rarity = rarity;
    }

    @Override
    public int hashCode(){
        return rarity;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Rarity)
            return compareTo((Rarity)object) == 0;
        return false;
    }

    @Override
    public int compareTo(Rarity rare) {
        int otherRarity = rare.rarity;
        return Integer.compare(rarity, otherRarity);
    }

    @Override
    public String toString(){
        return Integer.toString(rarity);
    }
}
