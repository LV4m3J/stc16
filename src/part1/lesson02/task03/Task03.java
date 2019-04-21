package part1.lesson02.task03;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class Task03 {
    private static int numOfElements = 10000;
    private static Person[] persons = new Person[numOfElements];

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numOfElements; i++) {
            persons[i] = new Person(Utils.utilsRandAge(),Utils.utilsRandSex(),Utils.utilsRandName());
            System.out.println(i + " = " + persons[i].toString());
        }
        long totalTime = System.currentTimeMillis() - startTime;
        //int seconds = cal.get(Calendar.SECOND);
        System.out.println(totalTime);

    }
}

//TODO: Задание 3. Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
// sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка).
// Создать два класса, методы которых будут реализовывать сортировку объектов. Предусмотреть единый интерфейс для классов сортировки.
// Реализовать два различных метода сортировки этого массива по правилам:
//  первые идут мужчины
//  выше в списке тот, кто более старший
//  имена сортируются по алфавиту
//  Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
//  Предусмотреть генерацию исходного массива (10000 элементов и более).
//  Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.