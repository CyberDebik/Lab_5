package Commands;

import App.VehicleList;
import Classes.Vehicle;

/**
 * Класс команды add_if_max
 */
public class Add_if_max extends Command {

    private Add add = new Add();

    /**
     * Поле для сравнения
     */
    private long maxVh = 0;

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String[] strings = data.split(" ");
        String name = strings[0].trim();
        if (strings.length != 1) {
            System.out.println("Команда введена неверно\n");
        } else if (name.isEmpty()) {
            System.out.println("Вы не ввели имя\n");
        } else {
            for (Vehicle vehicle : vehicleList.vehicles) {
                if (maxVh < vehicle.getSize()) {
                    maxVh = vehicle.getSize();
                }
            }
            Vehicle add_if_max = new Vehicle(name, add.setX(), add.setY(), add.setEnginePower(), add.setNumberOfWheels(), add.setVehicleType(), add.setFuelType());
            vehicleList.vehicles.add(add_if_max);
            if (add_if_max.getSize() < maxVh) {
                vehicleList.vehicles.remove(add_if_max);
                System.out.println("Элемент не максимальный\n");
            } else {
                System.out.println("Элемент добавлен");
            }
        }
    }
}
