package App;

import Classes.Vehicle;
import Commands.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Класс содержащий команды и коллекцию vehicles
 */
public class VehicleList {

    /**
     * Поле работы программы
     */
    public boolean status = true;

    /**
     * Коллекция с командами
     */
    public HashMap<String, Command> commandMap = new HashMap<>();

    /**
     * Коллекция, содержащая объекты Vehicle
     */
    public HashSet<Vehicle> vehicles = new HashSet<>();


    /**
     * Метод, добавляющтй камманды в коллекцию
     */
    private void setCommands() {
        commandMap.put("help", new Help());
        commandMap.put("info", new Info());
        commandMap.put("show", new Show());
        commandMap.put("add", new Add());
        commandMap.put("update", new Update());
        commandMap.put("remove_by_id", new Remove_by_id());
        commandMap.put("clear", new Clear());
        commandMap.put("exit", new Exit());
        commandMap.put("add_if_max", new Add_if_max());
        commandMap.put("remove_greater", new Remove_greater());
        commandMap.put("remove_lower", new Remove_lower());
        commandMap.put("group_counting_by_number_of_wheels", new Group_counting_by_number_of_wheels());
        commandMap.put("filter_greater_than_type", new Filter_greater_than_type());
        commandMap.put("print_field_ascending_number_of_wheels", new Print_field_ascending_number_of_wheels());
        commandMap.put("save", new Save());
        commandMap.put("execute_script", new Execute_script());
    }

    /**
     * Метод для проверки и выполнения введённой команды
     *
     * @param command - команда
     * @throws IOException если что-то пойдет не так
     */
    public void commandChoose(String command) throws IOException {
        setCommands();
        String[] strings = command.split("!");
        command = strings[0].trim().toLowerCase();
        if (commandMap.get(command) != null) {
            Command command_execute = commandMap.get(command);
            command_execute.execute(this, strings[1].trim());
        } else if (!command.equals("")) {
            System.out.println("Такой комманды нет, для просмотра всех достуных комманд введите \"help\"\n");
        }
    }
}
