package Commands;

import App.VehicleList;

/**
 * Класс команды exit
 */
public class Exit extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String[] strings = data.split(" ");
        if (!strings[0].isEmpty()) {
            System.out.println("Команда введена неверно\n");
        } else {
            vehicleList.status = false;
        }
    }
}