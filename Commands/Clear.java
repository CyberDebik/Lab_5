package Commands;

import App.VehicleList;

/**
 * Класс команды clear
 */
public class Clear extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String[] strings = data.split(" ");
        if (!strings[0].isEmpty()) {
            System.out.println("Команда введена неверно\n");
        } else if (!vehicleList.vehicles.isEmpty()) {
            vehicleList.vehicles.clear();
            System.out.println("Коллекция очищена\n");
        } else {
            System.out.println("Коллекция пуста");
        }
    }
}
