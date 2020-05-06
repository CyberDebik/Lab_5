package commands;

import app.VehicleList;

/**
 * Класс команды info
 */
public class Info extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String[] strings = data.split(" ");
        if (!strings[0].isEmpty()) {
            System.out.println("Команда введена неверно");
        } else {
            System.out.println("Тип коллекции - HashSet;\n" + vehicleList.vehicles.size() + " элементов в коллекции" + "\nДата инициализации: " + vehicleList.localDate);
        }
    }
}
