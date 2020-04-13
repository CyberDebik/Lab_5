package App;

/**
 * Класс для проверки строк
 */
public class Check {

    /**
     * Добавляем разделитель, чтобы отделить команду
     *
     * @param command команда
     * @return Возвращает строку с разделителем
     */
    public static String toCmd(String command) {
        command = command.trim();
        String[] strings = command.split(" ");
        StringBuilder out = new StringBuilder();
        out.append(strings[0]).append("! ");
        for (int i = 1; i < strings.length; i++) {
            out.append(strings[i]).append(" ");
        }
        return out.toString();
    }

    /**
     * Проверяем, является ли строка числом типа int
     *
     * @param number число, которое надо проверить
     * @return Возвращает true, если число типа int
     */
    public static boolean checkInt(String number) {
        return number.matches("-?\\d+(\\d+)?");
    }

    /**
     * Проверяем, является ли строка числом типа float
     *
     * @param number число, которое надо проверить
     * @return Возвращает true, если число типа float
     */
    public static boolean checkFloat(String number) {
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
