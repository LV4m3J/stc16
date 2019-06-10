package part1.lesson02.task02;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Наглая копипаста реализации
 * с https://howtodoinjava.com/java8/secure-random-number-generation/
 * создаем генератор рандомных чисел
 */

public class SecRand {
    public static int genRand() throws NoSuchAlgorithmException {
        //secureRandomGenerator
        SecureRandom srg = SecureRandom.getInstance("SHA1PRNG");
        // Get 128 random bytes
        byte[] randomBytes = new byte[128];
        srg.nextBytes(randomBytes);

        //Get random integer
        int r = srg.nextInt();
        //Get random integer in range
        int randInRange = srg.nextInt(999999);
        return randInRange;
    }
}
