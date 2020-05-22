package commands;

import app.VehicleList;

/**
 * Интерфейс команд
 */
public interface ICommand {
    void execute(VehicleList vehicleList, String data) throws Exception;
}
