package monsterzoo.field;

import java.io.Serializable;

public class Distance implements Serializable, Comparable<Distance> {
    private static final double THRESHOLD = 1E-6;
    private static final long serialVersionUID = 371013285839565821L;

    private double distance;

    public Distance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Distance distanceObject) {
        double otherDistance = distanceObject.distance;
        return compareTo(otherDistance);
    }

    public int compareTo(double value){
        return Double.compare(distance, value);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(distance);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Distance)
            return difference((Distance) object).compareTo(THRESHOLD) < 0;
        return false;
    }

    public Distance add(Distance newDistance) {
        return new Distance(distance + newDistance.distance);
    }

    public Distance difference(Distance distanceObject) {
        double otherDistance = distanceObject.distance;
        return new Distance(Math.abs(distance - otherDistance));
    }

    @Override
    public String toString() {
        return Double.toString(distance);
    }
}
