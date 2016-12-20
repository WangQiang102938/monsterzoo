package monsterzoo;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name){
        this.name = name;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Name)
            return equals((Name)object);
        return false;
    }

    private boolean equals(Name nameObject){
        String otherName = nameObject.name;
        return Objects.equals(name, otherName);
    }

    @Override
    public String toString(){
        return name;
    }
}
