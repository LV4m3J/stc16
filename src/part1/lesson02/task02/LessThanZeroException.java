package part1.lesson02.task02;

public class LessThanZeroException extends Exception {
    /**
     * @param message - по большому счету исключение лишнее, так как генератор случайных чисел не генерирует
     *                отрицательные числа, и в нем есть проверка на отрицательные числа.
     *                By and large, the exception is superfluous, since the random number generator does not
     *                generate negative numbers, and it contains a check for negative numbers.
     */
    public LessThanZeroException(String message){
        super(message);
    }
}
