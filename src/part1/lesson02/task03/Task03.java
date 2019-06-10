package part1.lesson02.task03;

import part1.lesson02.task03.comparator.PersonAgeComparator;
import part1.lesson02.task03.comparator.PersonNameComparator;
import part1.lesson02.task03.comparator.PersonSexComparator;
import part1.lesson02.task03.util_and_exeption.DuplicatePersonException;

import java.util.Arrays;
import java.util.Comparator;

public class Task03 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        MakePersons makePersons = new MakePersons();
        try {
            Sort01 sort01 = new Sort01();
            sort01.bubbleSorter();
        } catch (DuplicatePersonException e) {
            e.printStackTrace();
        }
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время " + totalTime/1000 + " с.");
        Comparator<Person> pcomp = new PersonSexComparator().thenComparing(new PersonAgeComparator())
                .thenComparing(new PersonNameComparator());
        startTime = System.currentTimeMillis();
        try {
            Person[] persons = makePersons.getPersons();
            Arrays.sort(persons,pcomp);
            for (int i = 0; i < makePersons.getNumOfElements(); i++) {
                System.out.println(i + " = " + persons[i]);
            }
        } catch (DuplicatePersonException e) {
            e.printStackTrace();
        }
        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время " + totalTime + " мс.");

        //int seconds = cal.get(Calendar.SECOND);
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