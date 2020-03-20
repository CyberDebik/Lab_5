package Commands;

import App.VehicleList;
import Classes.Vehicle;

/**
 * Класс команды remove_greater
 */
public class Remove_greater extends Command {

    private Add add = new Add();

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String[] strings = data.split(" ");
        if (strings.length != 1) {
            System.out.println("Команда введена неверно\n");
        } else {
            String name = strings[0].trim();
            if (name.isEmpty()) {
                System.out.println("Вы не ввели имя\n");
            } else {
                Vehicle remove_greater = new Vehicle(name, add.setX(), add.setY(), add.setEnginePower(), add.setNumberOfWheels(), add.setVehicleType(), add.setFuelType());
                long maxVh = remove_greater.getSize();
                vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() > maxVh);
                vehicleList.vehicles.add(remove_greater);
                System.out.println("Элементы удалены");
                System.out.println();
            }
        }
    }
}
