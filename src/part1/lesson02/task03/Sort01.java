package part1.lesson02.task03;

import part1.lesson02.task03.util_and_exeption.DuplicatePersonException;

/**
 * Sort01 - BubbleSort
 * @author - Iskander V.
 * @version - 0.1
 * Facepalm
 */
public class Sort01 {

    private MakePersons makePersons = new MakePersons();
    private Person[] persons = makePersons.getPersons();
    private int elements = makePersons.getNumOfElements();

    public Sort01() throws DuplicatePersonException {
    }

    private void swap(int first, int second) {
        Person temp = persons[first];
        persons[first] = persons[second];
        persons[second] = temp;
    }
    private void printer() {
        for (int i = 0; i < elements; i++) {
            System.out.println(i + " = " + persons[i]);
        }
    }

    //

    /**
     * bubbleSorter - МЕТОД ПУЗЫРЬКОВОЙ СОРТИРОВКИ
     * нет сортировки по строкам
     */
    public final void bubbleSorter(){
        for (int out = elements - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(persons[in].getSex()!=(Sex.MAN)) {
                    swap(in , in+1);
                }
            }
            for (int in = 0; in < out; in++){
                if(persons[in].getSex().equals(Sex.MAN) & persons[in+1].getSex().equals(Sex.MAN)
                        & persons[in].getAge() < persons[in+1].getAge()) {
                    swap(in , in+1);
                }
            }

        }
        for (int out = elements - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(persons[in].getSex().equals(Sex.WOMAN) & persons[in+1].getSex().equals(Sex.WOMAN)
                        & persons[in].getAge() < persons[in+1].getAge()) {
                    swap(in , in+1);
                }
            }
        }
        printer();
    }
}
