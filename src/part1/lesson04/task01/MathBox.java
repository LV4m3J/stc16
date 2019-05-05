package part1.lesson04.task01;

import part1.lesson04.task02.ObjectBox;

import java.util.*;

public class MathBox<T extends Number> extends ObjectBox {

    private List<T> list = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox<?> boxMath = (MathBox<?>) o;
        return Objects.equals(list, boxMath.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "list=" + list +
                '}';
    }


    /**
     * MathBox - конструктор записывающий в коллекцию.
     * @param numArr - массив типа Number
     * */
    public MathBox(Number[] numArr) {
        int i = 0;
        for (Number number: numArr) {
            list.add((T) number);
        }
    }

    /**
     * summator - метод возвращает сумму элементов коллекции
     * @return - сумма элеменетов коллекции.
     * P.s. -> наглая копипаста с примера урока.
     */
    public double summator() {
        return list.stream()
                .map(Number::doubleValue)
                .reduce((s1, s2) -> s1 + s2).orElse(0D);
    }

    /**
     * splitter метод, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода.
     * Хранящиеся в объекте данные полностью заменяются результатами деления.
     * @param divider - делитель элемента коллекции
     */
    public void splitter(Number divider) {
        /*Number[] nums = list.stream().map(Number::doubleValue)
                .map(x -> x / divider.doubleValue())
                .toArray(Number[]::new);*/
        for (int i = 0; i < list.size(); i++) {
            Double dividend = list.get(i).doubleValue() / divider.doubleValue();
            list.set(i, (T) dividend);
        }
    }

    public void checkValue(Integer val) {
        Number intVal = val;
        if(list.contains(intVal)){
            list.remove(intVal);
            System.out.println("Объект удален.");
        } else {
            System.out.println("Объект не найден!");
        }
    }
}