package part1.lesson02.task03;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Utils {
    static Random random = new Random();
    public static int utilsRandAge(){
        return random.nextInt(101);
    }
    public static String utilsRandName(){
       return RandomStringUtils.randomAlphabetic(7);
    }
    public static Sex utilsRandSex() {
       Sex sex = (Math.random()>0.5) ? Sex.MAN : Sex.WOMAN;
       return sex;
    }
}
