package commands;

import app.Check;
import app.VehicleList;
import classes.Vehicle;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Класс команды update
 */
public class Update extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        Add add = new Add();
        String[] strings = data.split(" ");
        if (strings.length != 2) {
            System.out.println("Команда введена неверно");
        } else {
            if (strings[0].trim().isEmpty() || !Check.checkLong(strings[0].trim()) || strings[1].trim().isEmpty()) {
                System.out.println("Команда введена неверно");
            } else {
                ZonedDateTime time = null;
                long id = Long.parseLong(strings[0].trim());
                for (Vehicle vehicle : vehicleList.vehicles) {
                    if (Objects.equals(id, vehicle.getID())) {
                        time = vehicle.getCreationDate();
                    }
                }
                String name = strings[1].trim();
                if (vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id)) {
                    vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id);
                    vehicleList.vehicles.add(new Vehicle(id, name, add.setX(), add.setY(), time, add.setEnginePower(), add.setNumberOfWheels(), add.setVehicleType(), add.setFuelType()));
                    System.out.println("Элемент обновлён");
                } else {
                    System.out.println("Элемента с таким id нет");
                }
            }
        }
    }
}
