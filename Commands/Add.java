package Commands;

import App.Check;
import App.VehicleList;
import Classes.Vehicle;
import Enums.FuelType;
import Enums.VehicleType;

import java.util.Scanner;

/**
 * Класс команды add
 */
public class Add extends Command {

    Scanner scanner = new Scanner(System.in);

    /**
     * Метод для установки координаты "x"
     *
     * @return Возвращает введённую координату
     */
    public String setX() {
        System.out.println("Введите координату X");
        System.out.print(">");
        String x = scanner.nextLine().trim();
        boolean checking = false;
        while (!checking) {
            try {
                String for_check = x;
                Float.parseFloat(for_check);
                checking = true;
            } catch (Exception e) {
                System.out.println("Неправильный тип числа, повторите ввод: ");
                System.out.print(">");
                x = scanner.nextLine().trim();
            }
        }
        while (!Check.checkFloat(x) || (Float.parseFloat(x) < -615)) {
            System.out.println("Неправильный тип числа, повторите ввод: ");
            System.out.print(">");
            x = scanner.nextLine().trim();
        }
        return x;
    }

    /**
     * Метод для установки координаты "y"
     *
     * @return Возвращает введённую координату
     */
    public String setY() {
        System.out.println("Введите координату Y");
        System.out.print(">");
        String y = scanner.nextLine().trim();
        boolean checking = false;
        while (!checking) {
            try {
                String for_check = y;
                Float.parseFloat(for_check);
                checking = true;
            } catch (Exception e) {
                System.out.println("Неправильный тип числа, повторите ввод: ");
                System.out.print(">");
                y = scanner.nextLine().trim();
            }
        }
        while (!Check.checkFloat(y)) {
            System.out.println("Неправильный тип числа, повторите ввод: ");
            System.out.print(">");
            y = scanner.nextLine().trim();
        }
        return y;
    }

    /**
     * Метод для установки кол-ва колёс
     *
     * @return Возвращает введённое кол-во колёс
     */
    public String setNumberOfWheels() {
        System.out.println("Введите количество колёс");
        System.out.print(">");
        String wheels = scanner.nextLine().trim();
        boolean checking = false;
        while (!checking) {
            try {
                String for_check = wheels;
                Long.parseLong(for_check);
                checking = true;
            } catch (Exception e) {
                System.out.println("Неправильный тип числа, повторите ввод: ");
                System.out.print(">");
                wheels = scanner.nextLine().trim();
            }
            while (!Check.checkInt(wheels)) {
                System.out.println("Неправильный тип числа, повторите ввод: ");
                System.out.print(">");
                wheels = scanner.nextLine().trim();
            }
        }
        return wheels;
    }

    /**
     * Метод для установки мощности
     *
     * @return Возвращает введённую мощность
     */
    public String setEnginePower() {
        System.out.println("Введите мощность ");
        System.out.print(">");
        String enginePower = scanner.nextLine().trim();
        boolean checking = false;
        while (!checking) {
            try {
                String for_check = enginePower;
                Integer.parseInt(for_check);
                checking = true;
            } catch (Exception e) {
                System.out.println("Неправильный тип числа, повторите ввод: ");
                System.out.print(">");
                enginePower = scanner.nextLine().trim();
            }
        }
        while (!Check.checkInt(enginePower) || (Integer.parseInt(enginePower) <= 0)) {
            System.out.println("Неправильный тип числа, повторите ввод: ");
            System.out.print(">");
            enginePower = scanner.nextLine().trim();
        }
        return enginePower;
    }

    /**
     * Метод для установки типа транспорта
     *
     * @return Возвращает введённый тип транспорта
     */
    public VehicleType setVehicleType() {
        VehicleType type = null;
        System.out.println("Выберите тип: ");
        System.out.println("|PLANE,\n" +
                "|DRONE,\n" +
                "|BICYCLE,\n" +
                "|MOTORCYCLE");
        System.out.print(">");
        String vehicleType = scanner.nextLine().trim().toUpperCase();
        while (!(vehicleType.equals("PLANE") || vehicleType.equals("DRONE") || vehicleType.equals("BICYCLE") || vehicleType.equals("MOTORCYCLE") || vehicleType.equals("") || vehicleType.equals("null"))) {
            System.out.println("Такого варианта нет, повторите ввод: ");
            System.out.print(">");
            vehicleType = scanner.nextLine().trim().toUpperCase();
        }
        switch (vehicleType) {
            case ("PLANE"):
                type = VehicleType.PLANE;
                break;
            case ("DRONE"):
                type = VehicleType.DRONE;
                break;
            case ("BICYCLE"):
                type = VehicleType.BICYCLE;
                break;
            case ("MOTORCYCLE"):
                type = VehicleType.MOTORCYCLE;
                break;
            case (""):
            case ("null"):
                type = null;
        }
        return type;
    }

    /**
     * Метод для установки типа топлива
     *
     * @return Возвращает введённый тип топлива
     */
    public FuelType setFuelType() {
        System.out.println("Выберите тип топлива");
        System.out.println("|GASOLINE,\n" +
                "|ELECTRICITY,\n" +
                "|DIESEL,\n" +
                "|ALCOHOL,\n" +
                "|MANPOWER");
        System.out.print(">");
        String fuelType = scanner.nextLine().trim().toUpperCase();
        while (!(fuelType.equals("GASOLINE") || fuelType.equals("ELECTRICITY") || fuelType.equals("DIESEL") || fuelType.equals("ALCOHOL") || fuelType.equals("MANPOWER"))) {
            System.out.println("Такого варианта нет, повторите ввод: ");
            System.out.print(">");
            fuelType = scanner.nextLine().trim().toUpperCase();
        }
        return FuelType.valueOf(fuelType);
    }

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data)/* throws IOException*/ {
        String[] strings = data.split(" ");
        String name = strings[0].trim();
        if (strings.length != 1) {
            System.out.println("Команда введена неверно\n");
        } else if (name.isEmpty()) {
            System.out.println("Вы не ввели имя\n");
        } else {
            vehicleList.vehicles.add(new Vehicle(name, setX(), setY(), setEnginePower(), setNumberOfWheels(), setVehicleType(), setFuelType()));
            System.out.println("Элемент добавлен\n");
        }
    }
}
