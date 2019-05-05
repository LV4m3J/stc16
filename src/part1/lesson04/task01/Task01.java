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
        /*MathBox mb = new MathBox(numArr);
        System.out.println(mb.toString());
        mb.summator();
        mb.checkValue(5);
        mb.splitter(2);
        System.out.println(mb.toString());*/

        BoxMath<Double> bm = new BoxMath<>(numArr);
        System.out.println(bm.toString());
        System.out.println(bm.summator());
        bm.splitter(2.0);
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