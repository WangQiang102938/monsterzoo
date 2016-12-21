package monsterzoo.user;

import monsterzoo.field.Distance;

public class Egg{
    public static final Distance DEFAULT_INCUBATION = new Distance(3.0);

    private Distance incubation = new Distance(0);
    private Distance current = new Distance(0);

    public Egg(){
        this(DEFAULT_INCUBATION);
    }

    public Egg(Distance incubation){
        this.incubation = incubation;
    }

    public void walk(Distance distance){
        current = current.add(distance);
    }

    public boolean isIncubated(){
        return incubation.compareTo(current) <= 0;
    }

    @Override
    public String toString(){
        return String.format("卵(あと%s km)", 
                incubation.difference(current));
    }
}
