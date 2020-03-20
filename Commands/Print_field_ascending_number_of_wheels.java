package Commands;

import App.VehicleList;
import Classes.Vehicle;

import java.util.ArrayList;
import java.util.Collections;

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
            System.out.println("Команда введена неверно\n");
        } else {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (Vehicle vehicle : vehicleList.vehicles) {
                arrayList.add(vehicle.getNumberOfWheels());
            }
            Collections.sort(arrayList);
            for (Long numberOfWheels : arrayList) {
                for (Vehicle vehicle : vehicleList.vehicles) {
                    if (numberOfWheels.equals(vehicle.getNumberOfWheels())) {
                        System.out.println("У " + vehicle.getName() + " " + numberOfWheels + " колёс");
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}
