package part1.lesson05;

import java.util.Objects;

public class Person {
    private Integer age;
    private Sex sex;
    private String name;

    /**
     * Конструктор хозяина
     * @param age - возраст
     * @param sex - пол
     * @param name - имя
     */
    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    /**
     * Getter поля age
     * @return - интовое занчение возраста
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Getter поля sex
     * @return - из класса Sex пол
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Getter поля name
     * @return - строку имя
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age) &&
                sex == person.sex &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, sex, name);
    }
}



enum Sex {
    MAN("Мужчина"), WOMAN("Женщина");

    private String sex;
    /**
     * @param sex - строка обозначения пола person-a
     */
    Sex(String sex) {
        this.sex = sex;
    }
}
