package monsterzoo.user;

public class Count implements Comparable<Count>{
    private int count = 0;

    public Count(){
    }

    public Count(int count){
        this.count = count;
    }

    public int compareTo(Count otherCount){
        return Integer.compare(
                count, otherCount.count);
    }

    public Count add(Count newCount){
        return new Count(count + newCount.count);
    }

    public Count decrement(){
        return new Count(count - 1);
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString(){
        return Integer.toString(count);
    }
}
