package part1.lesson04.task01.Util;

import java.util.Random;

public class RandomNumGen {
    private static Random random = new Random();

    public static Number utilsRandNum(){
        //return random.nextInt(1000);
        return random.nextDouble() * 1000;
    }
}
