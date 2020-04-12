package App;

import Classes.Vehicle;
import Enums.FuelType;
import Enums.VehicleType;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 * Класс для чтения коллекции из файла
 */
public class CSV {

    public static void read(VehicleList vehicleList) {
        String file_path = System.getenv("COLLECTION");
        File file = new File(file_path);
        try {
            Scanner reader = new Scanner(file);
                Scanner scanner;
                String line;
                int index = 0;
                String name = null;
                String x = null;
                String y = null;
                ZonedDateTime date = null;
                String enginePower = null;
                String numberOfWheels = null;
                VehicleType type = null;
                FuelType fuelType = null;
                while (reader.hasNextLine()) {
                    line = reader.nextLine();
                    scanner = new Scanner(line);
                    scanner.useDelimiter(",");
                    try {
                        while (scanner.hasNext()) {
                            String info_from_file = scanner.next();
                            if (index == 0) {
                                name = info_from_file;
                            } else if (index == 1) {
                                x = info_from_file;
                            } else if (index == 2) {
                                y = info_from_file;
                            } else if (index == 3) {
                                date = ZonedDateTime.parse(info_from_file);
                            } else if (index == 4) {
                                enginePower = info_from_file;
                            } else if (index == 5) {
                                numberOfWheels = info_from_file;
                            } else if (index == 6) {
                                if (info_from_file.equals("PLANE") || info_from_file.equals("DRONE") || info_from_file.equals("BICYCLE") || info_from_file.equals("MOTORCYCLE"))
                                    type = VehicleType.valueOf(info_from_file);
                                else if (info_from_file.equals("null") || info_from_file.trim().equals(""))
                                    type = null;
                            } else if (index == 7) {
                                fuelType = FuelType.valueOf(info_from_file);
                            }
                            index++;
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка, неверный формат данных");
                        return;
                    }
                    vehicleList.vehicles.add(new Vehicle(name, x, y, date, enginePower, numberOfWheels, type, fuelType));
                    index = 0;
                }
                reader.close();
        } catch (Exception e) {
            System.out.println("Файл с коллекцией прочитать нельзя");
        }
    }
}