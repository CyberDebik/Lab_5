package commands;

import app.VehicleList;
import classes.Vehicle;

/**
 * Класс команды remove_greater
 */
public class Remove_greater extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        Add add = new Add();
        String[] strings = data.split(" ");
        if (strings.length != 1) {
            System.out.println("Команда введена неверно");
        } else {
            String name = strings[0].trim();
            if (name.isEmpty()) {
                System.out.println("Вы не ввели имя");
            } else {
                Vehicle remove_greater = new Vehicle(name, add.setX(), add.setY(), add.setEnginePower(), add.setNumberOfWheels(), add.setVehicleType(), add.setFuelType());
                long minVh = remove_greater.getSize();
                long collection_size = vehicleList.vehicles.size();
                vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() > minVh);
                if (vehicleList.vehicles.size() < collection_size) {
                    System.out.println("Элементы удалены");
                    vehicleList.vehicles.add(remove_greater);
                } else {
                    System.out.println("Элементов больше заданного нет");
                }
            }
        }
    }
}
