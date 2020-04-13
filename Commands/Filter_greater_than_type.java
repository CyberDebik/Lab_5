package Commands;

import App.Check;
import App.VehicleList;
import Classes.Vehicle;

/**
 * Класс команды filter_greater_than_type
 */
public class Filter_greater_than_type extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String[] strings = data.split(" ");
        String type;
        String number;
        if (strings.length != 2) {
            System.out.println("Команда введена неверно\n");
        } else {
            type = strings[0].trim();
            number = strings[1].trim();
            if (Check.checkFloat(number) || number.isEmpty()) {
                System.out.println("Неправильный тип числа\n");
            } else {
                float more_than = Float.parseFloat(number);
                switch (type) {
                    case ("coordinates"):
                        for (Vehicle vehicle : vehicleList.vehicles) {
                            if (more_than < vehicle.getCoordinates()) {
                                System.out.println(vehicle.getAll());
                            }
                        }
                        break;
                    case ("enginePower"):
                        for (Vehicle vehicle : vehicleList.vehicles) {
                            if (more_than < vehicle.getEnginePower()) {
                                System.out.println(vehicle.getAll());
                            }
                        }
                        break;
                    case ("numberOfWheels"):
                        for (Vehicle vehicle : vehicleList.vehicles) {
                            if (more_than < vehicle.getNumberOfWheels()) {
                                System.out.println(vehicle.getAll());
                            }
                        }
                        break;
                    default:
                        System.out.println("Такого поля нет\n");
                }
            }
        }
    }
}
