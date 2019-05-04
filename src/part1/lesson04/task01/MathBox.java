package part1.lesson04.task01;

import java.util.*;

public class MathBox <T> {
    private List<T> list = new ArrayList<>();
    private Double sum = 0.0;

    public MathBox(Number[] numberArray) {
        for (Number num :numberArray) {
            list.add((T)num);
        }
    }

    public void summator() {
        for (T val : list) {
            sum += (Double) val;
        }
        System.out.println(sum);
    }

    public void splitter(int divider) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(list, mathBox.list);
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
}
