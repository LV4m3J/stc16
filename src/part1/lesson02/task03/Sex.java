package part1.lesson02.task03;

public enum Sex {
    MAN("Мужчина"), WOMAN("Женщина");

    private String sex;

    /**
     * @param sex - строка обозначения пола person-a
     */
    Sex(String sex) {
        this.sex = sex;
    }
}
