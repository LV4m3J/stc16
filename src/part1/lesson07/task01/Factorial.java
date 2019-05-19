package part1.lesson07.task01;

import java.math.BigInteger;

class Factorial {
    /**
     * getFactorial
     * @param num - целочисленное значение расчитываемого числа
     * @return - факториал числа в виде строки
     */

    String getFactorial(int num) {
        BigInteger bigInteger = BigInteger.ONE;
        for (int j = 1; j <= num; j++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(j));
        }
        return bigInteger.toString();
    }
}
