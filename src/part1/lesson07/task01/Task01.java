package part1.lesson07.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Task01 {

    private static ExecutorService forkJoinPool = Executors.newWorkStealingPool();

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        Random random = new Random();
        int[] randNumb = new int[10];
        long startTime = System.currentTimeMillis();
        /**
         * 1 поточный расчет
         */
        for (int i = 0; i < randNumb.length; i++) {
            randNumb[i] = random.nextInt(10)+1;
            System.out.println(randNumb[i] + " факториал = " + factorial.getFactorial(randNumb[i]));
        }
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время " + totalTime + " мс.");
        startTime = System.currentTimeMillis();

        /**
         * Многопоточный расчет
         */
        List<Callable<String>> task = new ArrayList<>();
        try {
            for (int a:randNumb) {
                task.add(()->factorial.getFactorial(a));
            }
            List<Future<String>> futureList = forkJoinPool.invokeAll(task);
            for (Future<String> f : futureList) {
                System.out.println(f.get());
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
