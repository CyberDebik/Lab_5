package Commands;

import App.VehicleList;
import Classes.Vehicle;

/**
 * Класс команды group_counting_by_number_of_wheels
 */
public class Group_counting_by_number_of_wheels extends Command {
    int even = 0;
    int odd = 0;

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String[] strings = data.split(" ");
        if (!strings[0].isEmpty()) {
            System.out.println("Команда введена неверно\n");
        } else {
            for (Vehicle vehicle : vehicleList.vehicles) {
                if (vehicle.getNumberOfWheels() % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            System.out.println("Транспорт с четным количеством колёс: " + even);
            System.out.println("Транспорт с нечётным количеством колёс: " + odd);
            System.out.println();
        }
    }
}
