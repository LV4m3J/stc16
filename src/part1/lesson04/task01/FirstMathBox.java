package part1.lesson04.task01;

import java.util.*;

public class FirstMathBox<T> {
    private List<T>list = new ArrayList<>();
    private double sum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstMathBox mathBox = (FirstMathBox) o;
        return Objects.equals(list, mathBox.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "FirstMathBox{" +
                "list=" + list +
                '}';
    }

    public FirstMathBox(Number[] numberArray) {
        for (Number num : numberArray) {
            list.add((T)num);
        }
    }

    public void summator() {
        Number[] numArray = new Number[list.size()];
        list.toArray(numArray);
        for (Number num : numArray) {
            sum += num.doubleValue();
        }
        System.out.println(sum);
    }

    public void splitter(Number divider) {
        for (int i = 0; i < list.size(); i++) {
            Number dividend = (Double) list.get(i) / divider.doubleValue();
            list.set(i, (T) dividend);
        }
    }

    public void checkValue(Number val) {
        if(list.contains(val)){
            list.remove(val);
            System.out.println("Объект удален.");
        }
    }
}
