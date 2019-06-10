package part1.lesson04.task01;

import part1.lesson04.task01.Util.DuplicateNumException;
import part1.lesson04.task01.Util.RandomNumGen;

public class Task01 {

    public static void main(String[] args) {
        int arrSize = 10;

        Number[] numArr = new Number[arrSize];
        //Number[] numArr = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < arrSize; i++) {
            numArr[i] = RandomNumGen.utilsRandNum();
            for (int j = 0; j < i; j++) {
                if(numArr[j].equals(numArr[i])){
                    throw new DuplicateNumException("Одиноковое число!");
                }
            }
        }

        MathBox<Double> bm = new MathBox<>(numArr);
        System.out.println(bm.toString());
        System.out.println(bm.summator());
        bm.checkValue(2);
        bm.splitter(2);
        System.out.println(bm.toString());
        bm.checkValue(5);
    }

}
