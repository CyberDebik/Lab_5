package Commands;

import App.VehicleList;
import Classes.Vehicle;

/**
 * Класс команды show
 */
public class Show extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String[] strings = data.split(" ");
        if (!strings[0].isEmpty()) {
            System.out.println("Команда введена неверно");
        } else {
            for (Vehicle vehicle : vehicleList.vehicles) {
                System.out.println(vehicle);
            }
        }
    }
}
