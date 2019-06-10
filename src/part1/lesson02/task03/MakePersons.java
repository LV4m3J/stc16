package part1.lesson02.task03;

import part1.lesson02.task03.util_and_exeption.DuplicatePersonException;
import part1.lesson02.task03.util_and_exeption.Utils;

public class MakePersons {
    private int numOfElements = 10000;
    private Person[] persons = new Person[numOfElements];
    /**
     * getNumOfElements()
     * @return numOfElements - возвращает количество элементов массива
     */
    public int getNumOfElements() {
        return numOfElements;
    }

    /**
     * getPersons()
     * @return persons - возвращает массив типа Person
     */
    public Person[] getPersons() throws DuplicatePersonException {
        goMakePersons();
        return persons;
    }

    private void goMakePersons() throws DuplicatePersonException {
        for (int i = 0; i < numOfElements; i++) {
            for (int j = 0; j < i; j++) {
                if(persons[j].equals(persons[i])){
                    throw new DuplicatePersonException("Найден дубликат Person-a!");
                }
            }
            persons[i] = new Person(Utils.utilsRandAge(),Utils.utilsRandSex(),Utils.utilsRandName());
            //System.out.println(i + " = " + persons[i].toString());
        }
        //System.out.println("================= END array of persons =================");
    }
}
