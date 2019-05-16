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

//TODO Создать генератор текстовых файлов, работающий по следующим правилам:
//  Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
//  Слово состоит из 1<=n2<=15 латинских букв
//  Слова разделены одним пробелом
//  Предложение начинается с заглавной буквы
//  Предложение заканчивается (.|!|?)+" "
//  Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
//  Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в следующее предложение (1/probability).
//  Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
//  который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.