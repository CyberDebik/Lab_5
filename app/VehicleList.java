package app;

import classes.Vehicle;
import commands.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Класс содержащий команды и коллекцию vehicles
 */
public class VehicleList {

    /**
     * Время инициилизации коллекции
     */
    public final LocalDate initializationDate = LocalDate.now();

    /**
     * Коллекция, содержащая объекты Vehicle
     */
    public HashSet<Vehicle> vehicles = new HashSet<>();

    /**
     * Метод для проверки и выполнения введённой команды
     *
     * @param command команда
     * @throws Exception если что-то пойдет не так
     */
    public void commandChoose(String command) throws Exception {
        HashMap<String, Command> commandMap = new HashMap<>();
        commandMap.put("HELP", new Help());
        commandMap.put("INFO", new Info());
        commandMap.put("SHOW", new Show());
        commandMap.put("ADD", new Add());
        commandMap.put("UPDATE", new Update());
        commandMap.put("REMOVE_BY_ID", new Remove_by_id());
        commandMap.put("CLEAR", new Clear());
        commandMap.put("EXIT", new Exit());
        commandMap.put("ADD_IF_MAX", new Add_if_max());
        commandMap.put("REMOVE_GREATER", new Remove_greater());
        commandMap.put("REMOVE_LOWER", new Remove_lower());
        commandMap.put("GROUP_COUNTING_BY_NUMBER_OF_WHEELS", new Group_counting_by_number_of_wheels());
        commandMap.put("FILTER_GREATER_THAN_TYPE", new Filter_greater_than_type());
        commandMap.put("PRINT_FIELD_ASCENDING_NUMBER_OF_WHEELS", new Print_field_ascending_number_of_wheels());
        commandMap.put("SAVE", new Save());
        commandMap.put("EXECUTE_SCRIPT", new Execute_script());
        String[] strings = command.split(" ");
        command = strings[0].trim().toUpperCase();
        String data = "";
        for (int i = 1; i < strings.length; i++) {
            data += strings[i] + " ";
        }
        if (commandMap.get(command) != null) {
            Command command_execute = commandMap.get(command);
            command_execute.execute(this, data);
        } else if (!command.equals("")) {
            System.out.println("Такой комманды нет, для просмотра всех достуных комманд введите \"help\"");
        }
    }
}
