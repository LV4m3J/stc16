package part1.lesson02.task01;

public class Task01 {
    private static String str;

    public static void main(String[] args) {
        try {
            System.out.println("Hello, World!");
            Task01 task01 = new Task01();
            //task01.getNpe();
            //task01.getArrIndxOut();
            task01.getTask01Ex();
        } catch (Exception ex){
            ex.printStackTrace();
            ex.getMessage();
        }
    }

    /**
     * Выбраысаваем НПЕ
     * @throws NullPointerException
     */
    private void getNpe(){
        System.out.println(str.hashCode());
    }

    /**
     * Выбрасываем выход за пределы массива
     * @throws ArrayIndexOutOfBoundsException
     */
    private void getArrIndxOut(){
        int[] intArray = new int[] {1,2,3,4,5};
        System.out.println(intArray[intArray.length]);
    }

    /**
     * Выбрасываем свое собственное исключение
     * @throws GetOwnException
     * Имя метода указать полностью
     */
    private void getTask01Ex() throws GetOwnException{
        throw new GetOwnException("You have got your own exception.");
    }

}


// TODO: 20.04.2019 Задание 1. Написать программу ”Hello, World!”.
//  В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
//  Смоделировав ошибку «NullPointerException»
//  Смоделировав ошибку «ArrayIndexOutOfBoundsException»
//  Вызвав свой вариант ошибки через оператор throw