package Commands;

import App.Check;
import App.VehicleList;
import Classes.Vehicle;
import Enums.FuelType;
import Enums.VehicleType;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.Objects;
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
                                command = Check.toCmd(command);
                                String[] for_check = command.split("! ");
                                switch (for_check[0]) {
                                    case "add": {
                                        String[] add = for_check[1].split(" ");
                                        if (add.length == 7) {
                                            vehicleList.vehicles.add(new Vehicle(add[0], add[1], add[2], add[3], add[4], VehicleType.valueOf(add[5].toUpperCase()), FuelType.valueOf(add[6].toUpperCase())));
                                        } else if (add.length == 6) {
                                            vehicleList.vehicles.add(new Vehicle(add[0], add[1], add[2], add[3], add[4], null, FuelType.valueOf(add[5].toUpperCase())));
                                        }
                                        System.out.println("Элемент добавлен");
                                        break;
                                    }
                                    case "add_if_max": {
                                        String[] add = for_check[1].split(" ");
                                        long maxVh = 0;
                                        for (Vehicle vehicle : vehicleList.vehicles) {
                                            if (maxVh < vehicle.getSize()) {
                                                maxVh = vehicle.getSize();
                                            }
                                        }
                                        if (add.length == 7) {
                                            Vehicle add_if_max = new Vehicle(add[0], add[1], add[2], add[3], add[4], VehicleType.valueOf(add[5].toUpperCase()), FuelType.valueOf(add[6].toUpperCase()));
                                            vehicleList.vehicles.add(add_if_max);
                                            if (add_if_max.getSize() < maxVh) {
                                                vehicleList.vehicles.remove(add_if_max);
                                                System.out.println("Элемент не максимальный\n");
                                            }
                                        } else if (add.length == 6) {
                                            Vehicle add_if_max = new Vehicle(add[0], add[1], add[2], add[3], add[4], null, FuelType.valueOf(add[5].toUpperCase()));
                                            vehicleList.vehicles.add(add_if_max);
                                            if (add_if_max.getSize() < maxVh) {
                                                vehicleList.vehicles.remove(add_if_max);
                                                System.out.println("Элемент не максимальный\n");
                                            }
                                        }
                                        System.out.println("Элемент добавлен");
                                        break;
                                    }
                                    case "update": {
                                        String[] add = for_check[1].split(" ");
                                        ZonedDateTime time = null;
                                        long id = Long.parseLong(add[0]);
                                        for (Vehicle vehicle : vehicleList.vehicles) {
                                            if (Objects.equals(id, vehicle.getID())) {
                                                time = vehicle.getCreationDate();
                                            }
                                        }
                                        if (add.length == 8) {
                                            if (vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id)) {
                                                vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id);
                                                vehicleList.vehicles.add(new Vehicle(id, add[1], add[2], add[3], time, add[4], add[5], VehicleType.valueOf(add[6].toUpperCase()), FuelType.valueOf(add[7].toUpperCase())));
                                            } else {
                                                System.out.println("Элемента с таким id нет\n");
                                            }
                                        } else if (add.length == 7) {
                                            if (vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id)) {
                                                vehicleList.vehicles.removeIf(vehicle -> vehicle.getID() == id);
                                                vehicleList.vehicles.add(new Vehicle(id, add[1], add[2], add[3], time, add[4], add[5], null, FuelType.valueOf(add[6])));
                                            } else {
                                                System.out.println("Элемента с таким id нет\n");
                                            }
                                        }
                                        System.out.println("Элемент обновлён");
                                        break;
                                    }
                                    case "remove_greater": {
                                        String[] add = for_check[1].split(" ");
                                        if (add.length == 7) {
                                            Vehicle remove_greater = new Vehicle(add[0], add[1], add[2], add[3], add[4], VehicleType.valueOf(add[5].toUpperCase()), FuelType.valueOf(add[6].toUpperCase()));
                                            long maxVh = remove_greater.getSize();
                                            vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() > maxVh);
                                            vehicleList.vehicles.add(remove_greater);
                                            System.out.println();
                                        } else if (add.length == 6) {
                                            Vehicle remove_greater = new Vehicle(add[0], add[1], add[2], add[3], add[4], null, FuelType.valueOf(add[5].toUpperCase()));
                                            long maxVh = remove_greater.getSize();
                                            vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() > maxVh);
                                            vehicleList.vehicles.add(remove_greater);
                                            System.out.println();
                                        }
                                        System.out.println("Элементы удалены");
                                        break;
                                    }
                                    case "remove_lower":
                                        String[] add = for_check[1].split(" ");
                                        if (add.length == 7) {
                                            Vehicle remove_lower = new Vehicle(add[0], add[1], add[2], add[3], add[4], VehicleType.valueOf(add[5].toUpperCase()), FuelType.valueOf(add[6].toUpperCase()));
                                            long maxVh = remove_lower.getSize();
                                            vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() < maxVh);
                                            vehicleList.vehicles.add(remove_lower);
                                            System.out.println();
                                        } else if (add.length == 6) {
                                            Vehicle remove_greater = new Vehicle(add[0], add[1], add[2], add[3], add[4], null, FuelType.valueOf(add[5].toUpperCase()));
                                            long maxVh = remove_greater.getSize();
                                            vehicleList.vehicles.removeIf(vehicle -> vehicle.getSize() < maxVh);
                                            vehicleList.vehicles.add(remove_greater);
                                            System.out.println();
                                        }
                                        System.out.println("Элементы удалены");
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