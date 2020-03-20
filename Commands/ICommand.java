package Commands;

import App.VehicleList;

import java.io.IOException;

/**
 * Интерфейс команд
 */
public interface ICommand {
    void execute(VehicleList vehicleList, String data) throws IOException;
}