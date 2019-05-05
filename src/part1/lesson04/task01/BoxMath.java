package part1.lesson04.task01;

import javax.print.attribute.standard.NumberUp;
import java.util.*;
import java.util.stream.Collectors;

public class BoxMath <T extends Number> {

    private ArrayList<T> list = new ArrayList<>();
    private HashMap<Integer, T> hm = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxMath<?> boxMath = (BoxMath<?>) o;
        return Objects.equals(hm, boxMath.hm) &&
                Objects.equals(list, boxMath.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hm, list);
    }

    @Override
    public String toString() {
        return "BoxMath{" +
                "hm=" + hm +
                ", list=" + list +
                '}';
    }

    /**
     * BoxMath - конструктор записывающий в коллекцию.
     * @param numArr - массив типа Number
     * */
    public BoxMath(Number[] numArr) {
        int i = 0;
        for (Number number: numArr) {
            list.add((T) number);
            hm.put( i++, (T) number);
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

    public <T> void splitter(Number divider) {
        List<Number> some = list.stream()
                .map(Number::doubleValue)
                .map(x -> x / divider.doubleValue())
                .collect(Collectors.toList());
        /*for (int i = 0; i < list.size(); i++) {
            Number dividend = list.get(i);
            //list.set(i, dividend.doubleValue() / divider.doubleValue());
        }*/
    }

}

//TODO Задание 1. Написать класс MathBox, реализующий следующий функционал:
//// 1. Конструктор на вход получает массив Number. Элементы не могут повторяться.
//// Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
//// 2. Существует метод summator, возвращающий сумму всех элементов коллекции.
//// 3. Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода.
//// Хранящиеся в объекте данные полностью заменяются результатами деления.
//// 4. Необходимо правильно переопределить методы toString, hashCode, equals,
//// чтобы можно было использовать MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
//// Выполнение контракта обязательно!
//// 5. Создать .метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его