package part1.lesson07.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Task01 {

    //private static ExecutorService executorService = Executors.newFixedThreadPool(4);
    private static ExecutorService forkJoinPool = Executors.newWorkStealingPool();

    public static void main(String[] args) {
        List<Callable<Object>> task = new ArrayList<>();
        Factorial factorial = new Factorial();
        Random random = new Random();
        int[] randNumb = new int[10];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < randNumb.length; i++) {
            randNumb[i] = random.nextInt(10)+1;
            //System.out.println(randNumb[i] + " факториал = " + factorial.getFactorial(randNumb[i]));
        }
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время " + totalTime + " мс.");
        startTime = System.currentTimeMillis();

        try {
            for (int a:randNumb) {
                task.add(()->factorial.getFactorial(a));
            }
            //System.out.println(forkJoinPool.invokeAll(task));
            List<Future<Object>> futureList = forkJoinPool.invokeAll(task);
            for (Future<Object> f : futureList) {
                System.out.println(f.get().toString());
            }
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        } finally {
            forkJoinPool.shutdown();
        }
        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время " + totalTime + " мс.");

    }
}

//TODO Дан массив случайных чисел. Написать программу для вычисления факториалов всех элементов массива.
// Использовать пул потоков для решения задачи.
// Особенности выполнения:
// Для данного примера использовать рекурсию - не очень хороший вариант, т.к. происходит большое выделение памяти, очень вероятен StackOverFlow.
// Лучше перемножать числа в простом цикле при этом создавать объект типа BigInteger
// По сути, есть несколько способа решения задания:
// 1) распараллеливать вычисление факториала для одного числа
// 2) распараллеливать вычисления для разных чисел
// 3) комбинированный
// При чем вычислив факториал для одного числа, можно запомнить эти данные и использовать их для вычисления другого, что будет гораздо быстрее
