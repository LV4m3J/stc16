package part1.lesson08.task01;

public interface Serializer {
    /**
     * serialize - класс сериализации
     * @param object - объект для сериализации
     * @param file - имя файла, можнос указать путь
     */
    void serialize(Object object, String file);

    /**
     * deSerialize - класс десериализации
     * @param file - путь до файла
     * @return - возвращает объект десериализации
     */
    Object deSerialize(String file);
}
