package App;

import java.io.IOException;
import java.util.Scanner;

/**
 * Используется для запуска приложения
 */
public class App {

    /**
     * Название комманды
     */
    String command;
    Scanner scanner = new Scanner(System.in);

    /**
     * Объект хранящий коллекцию vehicles
     */
    VehicleList vehicleList = new VehicleList();


    /**
     * Метод для запуска программы
     *
     * @throws IOException если что-то пойдет не так
     */
    public void start() throws IOException {
        CSV.read(vehicleList);
        while (vehicleList.status) {
            System.out.print("Введите команду: ");
            command = scanner.nextLine();
            command = Check.toCmd(command);
            vehicleList.commandChoose(command);
        }
    }
}