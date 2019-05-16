package part1.lesson06.task01;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Task01 {
    public static void main(String[] args) {
        /**
         * outputPath, inputPath - пути файлов
         */
        Path outputPath = Paths.get("src" + File.separator + "part1" + File.separator +
                "lesson06" + File.separator + "task01" + File.separator + "output.txt");
        String inputPath = "src" + File.separator + "part1" + File.separator +
                "lesson06" + File.separator + "task01" + File.separator + "input.txt";

        Set<String> stringSet = new TreeSet<>();
        /**
         * Блок трай
         */
        try(Scanner scanner = new Scanner(new FileInputStream(inputPath))) {
            while (scanner.hasNext()){
                String word = scanner.next().replaceAll("[.!?,]","").toLowerCase();
                stringSet.add(word);
            }
            scanner.close();
            stringSet.forEach(System.out::println);
            Files.write(outputPath,stringSet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
