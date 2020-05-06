package commands;

import app.VehicleList;
import classes.Vehicle;

import java.util.Collections;

/**
 * Класс команды add_if_max
 */
public class Add_if_max extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        Add add = new Add();
        String[] strings = data.split(" ");
        String name = strings[0].trim();
        if (strings.length != 1) {
            System.out.println("Команда введена неверно");
        } else if (name.isEmpty()) {
            System.out.println("Вы не ввели имя");
        } else {
            Vehicle add_if_max = new Vehicle(name, add.setX(), add.setY(), add.setEnginePower(), add.setNumberOfWheels(), add.setVehicleType(), add.setFuelType());
            if (add_if_max.compareTo(Collections.max(vehicleList.vehicles)) <= 0) {
                System.out.println("Элемент не максимальный");
            } else {
                vehicleList.vehicles.add(add_if_max);
                System.out.println("Элемент добавлен");
            }
        }
    }
}
