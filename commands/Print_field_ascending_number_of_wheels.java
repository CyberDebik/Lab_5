package commands;

import app.VehicleList;
import classes.NumberOfWheelsComparator;
import classes.Vehicle;

import java.util.ArrayList;

/**
 * Класс команды print_field_ascending_number_of_wheels
 */
public class Print_field_ascending_number_of_wheels extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String[] strings = data.split(" ");
        if (!strings[0].isEmpty()) {
            System.out.println("Команда введена неверно");
        } else {
            ArrayList<Vehicle> arrayList = new ArrayList<>(vehicleList.vehicles);
            arrayList.sort(new NumberOfWheelsComparator());
            for (Vehicle vehicle : arrayList) {
                System.out.println("У " + vehicle.getName() + " " + vehicle.getNumberOfWheels() + " колёс");
            }
        }
    }
}
