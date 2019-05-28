package part1.lesson08.task01;

public interface Serializer {
    void serialize(Object object, String file);

    Object deSerialize(String path);
}
