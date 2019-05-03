package part1.lesson02.task03.comparator;

import part1.lesson02.task03.Person;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge()>o2.getAge()) {
            return -1;
        } else if(o1.getAge()<o2.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }

}
