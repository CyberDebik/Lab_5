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
    private static String command;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Объект хранящий коллекцию vehicles
     */
    private static VehicleList vehicleList = new VehicleList();

    /**
     * Метод для запуска программы
     *
     * @throws IOException если что-то пойдет не так
     */
    public static void start() throws IOException {
        CSV.read(vehicleList);
        while (true) {
            System.out.print("Введите команду: ");
            command = scanner.nextLine();
            vehicleList.commandChoose(command);
            System.out.println();
        }
    }
}