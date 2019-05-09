package part1.lesson05;

public class Task01 {

    public static void main(String[] args) {
        PetLibrary petLib = new PetLibrary();

        for (Pet pet: Generator.petListGenerator()) {
            petLib.addPet(pet);
        }
        System.out.println("");
        petLib.setNewPetValue(7,"Pet_06",new Person(16,Sex.WOMAN,"Darya"),7.407825081161966);
        System.out.println("");
        System.out.println(petLib.searchPet("Pet_7"));
        System.out.println(petLib.searchPet("Pet_10"));

        petLib.printSortedPetLibrary();

    }
}
