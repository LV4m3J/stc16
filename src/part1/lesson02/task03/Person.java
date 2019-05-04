package part1.lesson02.task03;

public class Person {
    private int age;
    private Sex sex;
    private String name;

    public Person() {
    }

    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    /**
     * @return age - возвращает возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * @return sex - возвращает пол
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * @return name - возвращает имя
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
}
