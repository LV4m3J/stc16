package part1.lesson04.task01;

import java.util.*;

public class MathBox {
    private List<Number> list = new ArrayList<>();
    private double sum;

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

    public MathBox(Number[] numberArray) {
        for (Number num : numberArray) {
            list.add(num);
        }
    }

    public void summator() {
        Number[] numArray = new Number[list.size()];
        list.toArray(numArray);
        for (Number num : numArray) {
            sum += num.doubleValue();
        }
        /*for (Number val : list) {
            sum += (double) val;
        }*/
        System.out.println(sum);
    }

    public void splitter(Number divider) {
        for (int i = 0; i < list.size(); i++) {
            Number dividend = list.get(i);
            list.set(i, dividend.doubleValue()/divider.doubleValue());
        }
    }

    public void checkValue(Number val) {
        if(list.contains(val)){
            list.remove(val);
        }
    }
}
