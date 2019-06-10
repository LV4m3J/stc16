package part1.lesson05;

public class Task01 {

    public static void main(String[] args) {
        PetLibrary petLib = new PetLibrary();

        for (Pet pet: Generator.petListGenerator()) {
            petLib.addPet(pet);
        }
        System.out.println();
        petLib.setNewPetValue(7,"Pet_06",new Person(16,Sex.WOMAN,"Darya"),7.407825081161966);
        System.out.println();
        System.out.println(petLib.searchPet("Pet_7"));
        System.out.println(petLib.searchPet("Pet_10"));

        petLib.printSortedPetLibrary();

    }
}

//TODO Разработать программу – картотеку домашних животных. У каждого животного
// есть уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
//Реализовать:
//  метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
//  поиск животного по его кличке (поиск должен быть эффективным)
//  изменение данных животного по его идентификатору
//  вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
