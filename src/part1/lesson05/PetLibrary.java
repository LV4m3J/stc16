package part1.lesson05;

import java.util.HashMap;
import java.util.Map;

public class PetLibrary {

    private Map<String ,Pet> petMap = new HashMap<>();

    @Override
    public String toString() {
        return "PetLibrary{" +
                "petMap=" + petMap +
                '}';
    }

    /**
     * метод добавления животного в общий список
     * учесть, что добавление дубликатов должно приводить к исключительной ситуации
     * @param somePet - объект типа Pet
     */
    public void addPet(Pet somePet) {
        if(petMap.containsValue(somePet)) {
            throw new RuntimeException("Найден дубликат.");
        } else {
            petMap.put(somePet.getPetName(),somePet);
            System.out.println("Добавлен питомец: "+somePet.toString());
        }
    }

    /**
     * поиск животного по его кличке (поиск должен быть эффективным)
     * @param somePetName - имя питомца
     * @return - возвращает объект типа Pet или собщение
     */

    public String searchPet(String somePetName) {
        if(petMap.containsKey(somePetName)){
            return petMap.get(somePetName).toString();
        } else {
            return "Объект не найден!";
        }
    }

    /**
     * изменение данных животного по его идентификатору
     * @param identifier - идентификатор животного
     */
    public void setNewPetValue(int identifier, String newPetName, Person newPerson, double newWeight) {
        for (Map.Entry<String,Pet> petEntry: petMap.entrySet()) {
            if(petEntry.getValue().getId() == identifier) {
                System.out.println(petEntry.getValue().toString());
                petEntry.getValue().setPetName(newPetName);
                petEntry.getValue().setPerson(newPerson);
                petEntry.getValue().setWeight(newWeight);
                System.out.println(petEntry.getValue().toString());
            }
        }
    }

    /**
     * вывод на экран списка животных в отсортированном порядке
     */
    public void printSortedPetLibrary() {
        petMap.entrySet().stream().sorted(Map.Entry.<String,Pet>comparingByValue()).forEach(System.out::println);
    }
}
