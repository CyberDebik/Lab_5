package Classes;

import java.util.Comparator;

public class NumberOfWheelsComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return Long.compare(o1.getNumberOfWheels(), o2.getNumberOfWheels());
    }
}
