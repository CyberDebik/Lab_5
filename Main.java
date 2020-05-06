import app.CSV;
import app.VehicleList;

import java.io.IOException;
import java.util.Scanner;

/**
 * Класс Main
 */
public class Main {

    public static void main(String[] args) throws IOException {
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
