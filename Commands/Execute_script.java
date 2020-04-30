package Commands;

import App.Check;
import App.VehicleList;
import Classes.Vehicle;
import Enums.FuelType;
import Enums.VehicleType;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 * Класс команды execute_script
 */
public class Execute_script extends Command {

    /**
     * Поле названия команды
     */
    String command;

    /**
     * Файл со скриптом
     */
    File file;

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        try {
            String[] strings = data.split(" ");
            String file_name = strings[0].trim();
            String line;
            if (strings.length != 1) {
                System.out.println("Команда введена неверно");
            } else if (file_name.isEmpty()) {
                System.out.println("Вы не ввели имя файла");
            } else {
                try {
                    file = new File("/home/s284260/Lab5/" + file_name);
                    if (file.exists()) {
                        Scanner reader = new Scanner(file);
                        Scanner scanner;
                        while (reader.hasNextLine()) {
                            line = reader.nextLine();
                            scanner = new Scanner(line);
                            while (scanner.hasNext()) {
                                command = scanner.nextLine();
                                String[] stringsWithCommand = command.split(" ");
                                switch (stringsWithCommand[0].toUpperCase()) {
                                    case "ADD": {
                                        try {
                                            if ((!Check.checkFloat(stringsWithCommand[2]) && Check.checkMoreThan_minus_615(stringsWithCommand[2])) && !Check.checkFloat(stringsWithCommand[3]) && (!Check.checkInt(stringsWithCommand[4]) && !Check.checkPositive(stringsWithCommand[4])) && (!Check.checkInt(stringsWithCommand[5]) && !Check.checkPositive(stringsWithCommand[5]))) {
                                                if (stringsWithCommand.length == 8) {
                                                    vehicleList.vehicles.add(new Vehicle(stringsWithCommand[1], stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], stringsWithCommand[5], VehicleType.valueOf(stringsWithCommand[6].toUpperCase()), FuelType.valueOf(stringsWithCommand[7].toUpperCase())));
                                                    System.out.println("Элемент добавлен");
                                                } else if (stringsWithCommand.length == 7) {
                                                    vehicleList.vehicles.add(new Vehicle(stringsWithCommand[1], stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], stringsWithCommand[5], null, FuelType.valueOf(stringsWithCommand[6].toUpperCase())));
                                                    System.out.println("Элемент добавлен");
                                                }
                                            } else {
                                                System.out.println("Данные введены неверно");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Данные введены неверно");
                                        }
                                        break;
                                    }
                                    case "ADD_IF_MAX": {
                                        try {
                                            if ((!Check.checkFloat(stringsWithCommand[2]) && Check.checkMoreThan_minus_615(stringsWithCommand[2])) && !Check.checkFloat(stringsWithCommand[3]) && (!Check.checkInt(stringsWithCommand[4]) && !Check.checkPositive(stringsWithCommand[4])) && (!Check.checkInt(stringsWithCommand[5]) && !Check.checkPositive(stringsWithCommand[5]))) {
                                                long maxVh = 0;
                                                for (Vehicle vehicle : vehicleList.vehicles) {
                                                    if (maxVh < vehicle.getSize()) {
                                                        maxVh = vehicle.getSize();
                                                    }
                                                }
                                                if (stringsWithCommand.length == 8) {
                                                    Vehicle add_if_max = new Vehicle(stringsWithCommand[1], stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], stringsWithCommand[5], VehicleType.valueOf(stringsWithCommand[6].toUpperCase()), FuelType.valueOf(stringsWithCommand[7].toUpperCase()));
                                                    vehicleList.vehicles.add(add_if_max);
                                                    if (add_if_max.getSize() <= maxVh) {
                                                        vehicleList.vehicles.remove(add_if_max);
                                                        System.out.println("Элемент не максимальный");
                                                    } else {
                                                        System.out.println("Элемент добавлен");
                                                    }
                                                } else if (stringsWithCommand.length == 7) {
                                                    Vehicle add_if_max = new Vehicle(stringsWithCommand[1], stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], stringsWithCommand[5], null, FuelType.valueOf(stringsWithCommand[6].toUpperCase()));
                                                    vehicleList.vehicles.add(add_if_max);
                                                    if (add_if_max.getSize() <= maxVh) {
                                                        vehicleList.vehicles.remove(add_if_max);
                                                        System.out.println("Элемент не максимальный");
                                                    } else {
                                                        System.out.println("Элемент добавлен");
                                                    }
                                                }
                                            } else {
                                                System.out.println("Данные введены неверно");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Данные введены неверно");
                                        }
                                        break;
                                    }
                                    case "UPDATE": {
                                        try {
                                            if ((!Check.checkFloat(stringsWithCommand[3]) && Check.checkMoreThan_minus_615(stringsWithCommand[3])) && !Check.checkFloat(stringsWithCommand[4]) && (!Check.checkInt(stringsWithCommand[5]) && !Check.checkPositive(stringsWithCommand[5])) && (!Check.checkInt(stringsWithCommand[6]) && !Check.checkPositive(stringsWithCommand[6]))) {
                                                ZonedDateTime time = null;
                                                long id = Long.parseLong(stringsWithCommand[1]);
                                                for (Vehicle vehicle : vehicleList.vehicles) {
                                                    if (id == vehicle.getID()) {
                                                        time = vehicle.getCreationDate();
                                                    }
                                                }
                                                if (stringsWithCommand.length == 9) {
                                                    if (vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id)) {
                                                        vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id);
                                                        vehicleList.vehicles.add(new Vehicle(id, stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], time, stringsWithCommand[5], stringsWithCommand[6], VehicleType.valueOf(stringsWithCommand[7].toUpperCase()), FuelType.valueOf(stringsWithCommand[8].toUpperCase())));
                                                        System.out.println("Элемент обновлён");
                                                    } else {
                                                        System.out.println("Элемента с таким id нет");
                                                    }
                                                } else if (stringsWithCommand.length == 8) {
                                                    if (vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id)) {
                                                        vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id);
                                                        vehicleList.vehicles.add(new Vehicle(id, stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], time, stringsWithCommand[5], stringsWithCommand[6], null, FuelType.valueOf(stringsWithCommand[7].toUpperCase())));
                                                        System.out.println("Элемент обновлён");
                                                    } else {
                                                        System.out.println("Элемента с таким id нет");
                                                    }
                                                }
                                            } else {
                                                System.out.println("Данные введены неверно");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Данные введены неверно");
                                        }
                                        break;
                                    }
                                    case "REMOVE_GREATER": {
                                        try {
                                            if ((!Check.checkFloat(stringsWithCommand[2]) && Check.checkMoreThan_minus_615(stringsWithCommand[2])) && !Check.checkFloat(stringsWithCommand[3]) && (!Check.checkInt(stringsWithCommand[4]) && !Check.checkPositive(stringsWithCommand[4])) && (!Check.checkInt(stringsWithCommand[5]) && !Check.checkPositive(stringsWithCommand[5]))) {
                                                if (stringsWithCommand.length == 8) {
                                                    Vehicle remove_greater = new Vehicle(stringsWithCommand[1], stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], stringsWithCommand[5], VehicleType.valueOf(stringsWithCommand[6].toUpperCase()), FuelType.valueOf(stringsWithCommand[7].toUpperCase()));
                                                    long maxVh = remove_greater.getSize();
                                                    if (!vehicleList.vehicles.isEmpty()) {
                                                        vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() > maxVh);
                                                        System.out.println("Элементы удалены");
                                                    } else {
                                                        System.out.println("Коллекция пуста");
                                                    }
                                                    vehicleList.vehicles.add(remove_greater);
                                                } else if (stringsWithCommand.length == 7) {
                                                    Vehicle remove_greater = new Vehicle(stringsWithCommand[1], stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], stringsWithCommand[5], null, FuelType.valueOf(stringsWithCommand[6].toUpperCase()));
                                                    long maxVh = remove_greater.getSize();
                                                    if (!vehicleList.vehicles.isEmpty()) {
                                                        vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() > maxVh);
                                                        System.out.println("Элементы удалены");
                                                    } else {
                                                        System.out.println("Коллекция пуста");
                                                    }
                                                    vehicleList.vehicles.add(remove_greater);
                                                } else {
                                                    System.out.println("Элементов больше этого нет");
                                                }
                                            } else {
                                                System.out.println("Данные введены неверно");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Данные введены неверно");
                                        }
                                        break;
                                    }
                                    case "REMOVE_LOWER":
                                        try {
                                            if ((!Check.checkFloat(stringsWithCommand[2]) && Check.checkMoreThan_minus_615(stringsWithCommand[2])) && !Check.checkFloat(stringsWithCommand[3]) && (!Check.checkInt(stringsWithCommand[4]) && !Check.checkPositive(stringsWithCommand[4])) && (!Check.checkInt(stringsWithCommand[5]) && !Check.checkPositive(stringsWithCommand[5]))) {
                                                if (stringsWithCommand.length == 8) {
                                                    Vehicle remove_greater = new Vehicle(stringsWithCommand[1], stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], stringsWithCommand[5], VehicleType.valueOf(stringsWithCommand[6].toUpperCase()), FuelType.valueOf(stringsWithCommand[7].toUpperCase()));
                                                    long maxVh = remove_greater.getSize();
                                                    if (!vehicleList.vehicles.isEmpty()) {
                                                        vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() < maxVh);
                                                        System.out.println("Элементы удалены");
                                                    } else {
                                                        System.out.println("Коллекция пуста");
                                                    }
                                                    vehicleList.vehicles.add(remove_greater);
                                                } else if (stringsWithCommand.length == 7) {
                                                    Vehicle remove_greater = new Vehicle(stringsWithCommand[1], stringsWithCommand[2], stringsWithCommand[3], stringsWithCommand[4], stringsWithCommand[5], null, FuelType.valueOf(stringsWithCommand[6].toUpperCase()));
                                                    long maxVh = remove_greater.getSize();
                                                    if (!vehicleList.vehicles.isEmpty()) {
                                                        vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() < maxVh);
                                                        System.out.println("Элементы удалены");
                                                    } else {
                                                        System.out.println("Коллекция пуста");
                                                    }
                                                    vehicleList.vehicles.add(remove_greater);
                                                } else {
                                                    System.out.println("Элементов меньше этого нет");
                                                }
                                            } else {
                                                System.out.println("Данные введены неверно");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Данные введены неверно");
                                        }
                                        break;
                                    default:
                                        vehicleList.commandChoose(command);
                                        break;
                                }
                            }
                        }
                        reader.close();
                    } else {
                        System.out.println("Такого файла с командами не существует");
                    }
                } catch (Exception e) {
                    System.out.println("Этот файл прочитать нельзя");
                }
            }
        } catch (Error e) {
            System.out.println("Вы запустили бесконечный цикл, он будет прерван");
        }
    }
}