package Commands;

import App.Check;
import App.VehicleList;

/**
 * Класс команды remove_by_id
 */
public class Remove_by_id extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) /*throws IOException*/ {
        String[] strings = data.split(" ");
        if (strings.length != 1) {
            System.out.println("Команда введена неверно\n");
        } else if (strings[0].trim().isEmpty() || !Check.checkInt(strings[0].trim())) {
            System.out.println("Неправильный тип числа, повторите ввод\n");
        } else {
            long id = Long.parseLong(strings[0].trim());
            if (vehicleList.vehicles.removeIf(vehicle -> id == vehicle.getID())) {
                vehicleList.vehicles.removeIf(vehicle -> id == vehicle.getID());
                System.out.println("Элемент удалён\n");
            } else {
                System.out.println("Элемента с таким id нет\n");
            }
        }
    }
}
