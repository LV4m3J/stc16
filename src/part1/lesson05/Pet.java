package part1.lesson05;

import java.util.Objects;

public class Pet implements Comparable<Pet> {
    private int id;
    private String petName;
    private Person person;
    private Double weight;

    /**
     * counter - счетчик созданных объектов типа Pet
     */
    private static int counter = 1;

    /**
     * Конструктор класса Pet
     * @param petName - имя животного
     * @param person - хоязин, объект типа Person
     * @param weight - вес, значение double
     */
    public Pet(String petName, Person person, double weight) {
        this.id = counter;
        this.petName = petName;
        this.person = person;
        this.weight = weight;
        counter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) &&
                Objects.equals(petName, pet.petName) &&
                Objects.equals(person, pet.person) &&
                Objects.equals(weight, pet.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, petName, person, weight);
    }

    /**
     * Getter поля id
     * @return - int id
     */

    public int getId() {
        return id;
    }

    /**
     * Getter поля petName
     * @return - string petName
     */
    public String getPetName() {
        return petName;
    }
    /**
     * Getter поля person
     * @return - Объект типа Person
     */
    public Person getPerson() {
        return person;
    }
    /**
     * Getter поля weight
     * @return - Double weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Setter поля petName
     * @param petName - String имя животного
     */
    protected void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * Setter поля person
     * @param person - объект типа Person
     */
    protected void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Setter поля weight
     * @param weight - double вес
     */
    protected void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", petName='" + petName + '\'' +
                ", person=" + person +
                ", weight=" + weight +
                '}';
    }

    /**
     * Метод сравнения объектов типа Pet
     * @param o - входное значение
     * @return - int значение результата сравнения
     */
    @Override
    public int compareTo(Pet o) {
        int result = this.person.getName().compareToIgnoreCase(o.person.getName())
                + this.person.getAge().compareTo(o.person.getAge())
                + this.person.getSex().compareTo(o.person.getSex())
                + this.petName.compareToIgnoreCase(o.petName)
                + this.weight.compareTo(o.weight);
        return result;
    }
}
