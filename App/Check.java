package App;

/**
 * Класс для проверки строк
 */
public class Check {

    /**
     * Проверяем, является ли строка числом типа int
     *
     * @param number число, которое надо проверить
     * @return Возвращает true, если число типа int
     */
    public static boolean checkInt(String number) {
        return !number.matches("-?\\d+");
    }

    /**
     * Проверяем, является ли строка числом типа float
     *
     * @param number число, которое надо проверить
     * @return Возвращает true, если число типа float
     */
    public static boolean checkFloat(String number) {
        return !number.matches("[-+]?\\d*\\.?\\d+");
    }

    public static boolean checkPositive(String number) {
        return !number.matches("\\d*\\.?\\d+");
    }

}
