package part1.lesson02.task03.util_and_exeption;

import org.apache.commons.lang3.RandomStringUtils;
import part1.lesson02.task03.Sex;

import java.util.Random;

public class Utils {
    /**
     * Util class - класс с вспомогателными методами.
     * @author - Iskander V.
     * @version - 0.1
     * utilsRandAge
     * @return - возвращает случайное число от 0 до 100
     */
    private static Random random = new Random();

    public static int utilsRandAge(){
        return random.nextInt(101);
    }

    /**
     * utilsRandName
     * @return - возвращает случайную последовательность символов в размере 7 букв.
     */

    public static String utilsRandName(){
       return RandomStringUtils.randomAlphabetic(9);
    }

    /**
     * utilsRandSex
     * @return - возвращает случайное значение пола Person-a
     */
    public static Sex utilsRandSex() {
        return (Math.random()>0.5) ? Sex.MAN : Sex.WOMAN;
    }


}
