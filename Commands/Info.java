package Commands;

import App.VehicleList;

import java.time.LocalDate;

/**
 * Класс команды info
 */
public class Info extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) /*throws IOException*/ {
        String[] strings = data.split(" ");
        if (!strings[0].isEmpty()) {
            System.out.println("Команда введена неверно\n");
        } else {
            System.out.println("Тип коллекции - HashSet;\n" + vehicleList.vehicles.size() + " элементов в коллекции" + "\nInitialization Date: " + LocalDate.now());
            System.out.println();
        }
    }
}
