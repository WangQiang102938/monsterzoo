package monsterzoo.field;

import java.util.stream.IntStream;

import monsterzoo.monster.Rarity;
import monsterzoo.user.Count;

public class RandomValue {
    private int value;

    public RandomValue(int value){
        this.value = value;
    }

    public int compareTo(int value){
        return Integer.compare(
                this.value, value);
    }

    public RandomValue times(int times){
        return new RandomValue(value * times);
    }

    public boolean isBetween(int from, int to){
        return compareTo(from) >= 0 &&
                compareTo(to) < 0;
    }

    public Count toCount(){
        return new Count(value);
    }

    public Rarity toRarity(){
        return new Rarity(value);
    }

    public int toInteger(){
        return value;
    }

    public IntStream stream(){
        return IntStream.range(0, value);
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
