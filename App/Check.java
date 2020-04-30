package App;

/**
 * Класс для проверки строк
 */
public class Check {

    /**
     * Проверяем, является ли строка числом типа int
     *
     * @param number число, которое надо проверить
     * @return Возвращает false, если число типа int
     */
    public static boolean checkInt(String number) {
        return !number.matches("-?\\d+");
    }

    /**
     * Проверяем, является ли строка числом типа float
     *
     * @param number число, которое надо проверить
     * @return Возвращает false, если число типа float
     */
    public static boolean checkFloat(String number) {
        return !number.matches("[-+]?\\d*\\.?\\d+");
    }

    /**
     * Проверяем, является ли число положительным
     *
     * @param number число, которое надо проверить
     * @return Возвращает false, если число положительное
     */
    public static boolean checkPositive(String number) {
        return !number.matches("\\d*\\.?\\d+");
    }

    /**
     * Проверяем, больше ли число -615
     *
     * @param number число, которое надо проверить
     * @return Возвращает true, если число больше -615
     */
    public static boolean checkMoreThan_minus_615(String number) {
        try {
            boolean check = false;
            float num = Float.parseFloat(number);
            if (num > -615) {
                check = true;
            }
            return check;
        } catch (Exception e) {
            return false;
        }
    }

}
