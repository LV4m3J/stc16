package part1.lesson05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generator {

    private static List<Person> personList = new ArrayList<>(Arrays.asList(
            new Person(7,Sex.MAN,"Vasya"),
            new Person(14,Sex.WOMAN,"Nastya"),
            new Person(13,Sex.MAN,"Petya"),
            new Person(11,Sex.WOMAN,"Masha"),
            new Person(10,Sex.MAN,"Jenya"),
            new Person(32,Sex.WOMAN,"Alisa"),
            new Person(22,Sex.WOMAN,"Alisa"),
            new Person(12,Sex.WOMAN,"Anjella"),
            new Person(18,Sex.WOMAN,"Ksenya"),
            new Person(19,Sex.WOMAN,"Vera")));

    public static List<Pet> petListGenerator() {
        List<Pet> petList = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            petList.add(new Pet("Pet_"+i, personList.get(i), Math.random()*10));
        }
        return petList;
    }
}
