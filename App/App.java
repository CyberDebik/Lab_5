package App;

import java.io.IOException;
import java.util.Scanner;

/**
 * Используется для запуска приложения
 */
public class App {

    /**
     * Метод для запуска программы
     *
     * @throws IOException если что-то пойдет не так
     */
    public static void start() throws IOException {
        VehicleList vehicleList = new VehicleList();
        CSV.read(vehicleList);
        while (true) {
            System.out.print("Введите команду: ");
            String command = new Scanner(System.in).nextLine();
            vehicleList.commandChoose(command);
            System.out.println();
        }
    }
}