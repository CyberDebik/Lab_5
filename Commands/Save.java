package Commands;

import App.VehicleList;
import Classes.Vehicle;

import java.io.*;

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
            System.out.println("Команда введена неверно\n");
        } else {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
                for (Vehicle vehicle : vehicleList.vehicles) {
                    bufferedWriter.write(vehicle.info_for_file());
                }
                bufferedWriter.close();
                System.out.println("Коллекция сохранена в файл " + file.getAbsolutePath());
                System.out.println();
            } catch (Exception e) {
                System.out.println("Нельзя записать коллекцию в этот файл\n");
            }
        }
    }
}
