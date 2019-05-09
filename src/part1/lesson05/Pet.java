package part1.lesson05;

import java.util.Objects;

public class Pet implements Comparable<Pet> {
    private int id;
    private String petName;
    private Person person;
    private Double weight;

    private static int counter = 1;

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

    public int getId() {
        return id;
    }

    public String getPetName() {
        return petName;
    }

    public Person getPerson() {
        return person;
    }

    public double getWeight() {
        return weight;
    }

    protected void setPetName(String petName) {
        this.petName = petName;
    }

    protected void setPerson(Person person) {
        this.person = person;
    }

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

    @Override
    public int compareTo(Pet o) {
        int result = o.person.getName().compareToIgnoreCase(this.person.getName())
                + o.petName.compareToIgnoreCase(this.petName)
                + o.weight.compareTo(this.weight);
        return result;
    }
}
