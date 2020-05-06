package commands;

import app.VehicleList;
import classes.Vehicle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Класс команды save
 */
public class Save extends Command {

    /**
     * Метод выполнения команды
     */
    @Override
    public void execute(VehicleList vehicleList, String data) {
        String file_path = System.getenv().get("COLLECTION");
        File file = new File(file_path);
        String[] strings = data.split(" ");
        if (!strings[0].isEmpty()) {
            System.out.println("Команда введена неверно");
        } else {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
                for (Vehicle vehicle : vehicleList.vehicles) {
                    bufferedWriter.write(vehicle.info_for_file());
                }
                bufferedWriter.close();
                System.out.println("Коллекция сохранена в файл " + file.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Нельзя записать коллекцию в этот файл");
            }
        }
    }
}
