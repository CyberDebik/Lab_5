package Classes;

/**
 * Класс координат
 */
public class Coordinates {

    /**
     * Координата "x"
     */
    private float x; //Значение поля должно быть больше -615

    /**
     * Координата "y"
     */
    private Float y; //Поле не может быть null

    /**
     * Конструктор
     *
     * @param x - координата
     * @param y - координата
     */
    public Coordinates(float x, Float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод для получения координаты "x"
     *
     * @return Возвращает координату "x"
     */
    public float getX() {
        return x;
    }

    /**
     * Метод для получения координаты "y"
     *
     * @return Возвращает координату "y"
     */
    public float getY() {
        return y;
    }

}