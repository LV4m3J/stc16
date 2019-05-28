package part1.lesson11;

import java.math.BigInteger;
import java.util.stream.Stream;

class Factorial {
    /**
     * getFactorial - изменение на лямбду
     * @param num - целочисленное значение расчитываемого числа
     * @return - факториал числа в виде строки
     */

    String getFactorial(int num) {
        BigInteger bigInteger = BigInteger.ONE;
        return bigInteger.multiply(Stream.iterate(BigInteger.valueOf(1),i->i.add(BigInteger.ONE))
                .limit(num)
                .reduce((previous, current) -> previous.multiply(current))
                .get()).toString();
    }
}
