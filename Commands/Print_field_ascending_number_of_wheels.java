package Commands;

import App.VehicleList;
import Classes.Vehicle;
import Classes.NumberOfWheelsComparator;

import java.util.ArrayList;

/**
 * Класс команды print_field_ascending_number_of_wheels
 */
public class Print_field_ascending_number_of_wheels extends Command {

    NumberOfWheelsComparator numberOfWheelsComparator = new NumberOfWheelsComparator();

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
            arrayList.sort(numberOfWheelsComparator);
            for (Vehicle vehicle : arrayList) {
                System.out.println("У " + vehicle.getName() + " " + vehicle.getNumberOfWheels() + " колёс");
            }
        }
    }
}
