package part1.lesson02.task02;

import java.security.NoSuchAlgorithmException;

public class Check {
    /**
     * check() - метод проверки, что квадратный корень числа при возведении в квадрат будут равны.
     *           the method of checking that the square root of a number during squaring will be equal.
     * randNumArr - первоначально пустой массив.
     *              initially empty array
     */

    public void check() {
        int[] randNumArr = new int[10];
        try {
            for (int i = 0; i < randNumArr.length; i++) {
                randNumArr[i] = SecRand.genRand();
                //System.out.println(i + " = " + randNumArr[i]);
            }
            double[] sqrRandNum = SquRt.squrt(randNumArr);
            for (int i = 0; i < randNumArr.length; i++) {
                if(randNumArr[i] == (int) Math.pow(sqrRandNum[i], 2)){
                    System.out.println(i + " = " + sqrRandNum[i]);
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (LessThanZeroException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
