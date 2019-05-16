package part1.lesson06.task02;

import java.io.File;

public class Task02 {
    public static void main(String[] args) {
        Generator generator = new Generator();
        String outputPath = "src" + File.separator + "part1" + File.separator +
                "lesson06" + File.separator + "task02" + File.separator + "output";
        String[] someStrings = new String[]{"1","2","3","4","5","6","7","8","9","0"};
        generator.getFiles(outputPath,3,1024,someStrings,1);
    }
}
