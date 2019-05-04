package part1.lesson04.task02;

import java.util.ArrayList;

public class ObjectBox {
    private ArrayList<Object> aro = new ArrayList<>();

    /**
     * addObject метод добавляет передаваемый параметр в коллекцию
     * @param o - объект добавляемый в коллекцию
     */
    public void addObject(Object o){
        aro.add(o);
    }

    /**
     * deleteObject метод ищет и удаляет если найдет объект из коллекции
     * @param o - удаляемый объект из коллекции
     */
    public void deleteObject(Object o){
        if (aro.contains(o)){
            aro.remove(o);
        }
    }

    /**
     * dump - метод выводит содержимое коллекции
     */
    public void dump() {
        System.out.println(aro.toString());
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "aro=" + aro +
                '}';
    }
}
