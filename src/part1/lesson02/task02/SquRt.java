package part1.lesson02.task02;

public class SquRt {
    /**
     * squrt - Выводим значение квадратного корня из числа в массиве
     *         We derive the square root of the number in the array
     * @param arr - переданный массив случайных чисел
     *            - transferred array of random numbers
     * @return sqrArr - возвращаем массив чисел после вычисления квадратного корня
     *                  return an array of numbers after calculating the square root
     */

    public static double[] squrt(int[] arr) throws LessThanZeroException {
        double[] sqrArr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0) {
                sqrArr[i] = Math.sqrt(arr[i]);
            } else {
                throw new LessThanZeroException("Невенрное значение. Число меньше нуля");
            }
        }
        return sqrArr;
    }
}
