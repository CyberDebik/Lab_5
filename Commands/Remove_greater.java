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
            System.out.println("Команда введена неверно");
        } else {
            String name = strings[0].trim();
            if (name.isEmpty()) {
                System.out.println("Вы не ввели имя");
            } else {
                Vehicle remove_greater = new Vehicle(name, add.setX(), add.setY(), add.setEnginePower(), add.setNumberOfWheels(), add.setVehicleType(), add.setFuelType());
                long maxVh = remove_greater.getSize();
                long collection_size = vehicleList.vehicles.size();
                vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() > maxVh);
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
