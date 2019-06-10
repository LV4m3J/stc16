package part1.lesson06.task02;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    /**
     * n1 - Предложение состоит из 1<=n1<=15 слов.
     * n2 - Слово состоит из 1<=n2<=15 латинских букв.
     * n3 - В одном абзаце 1<=n3<=20 предложений.
     * n4 - Массив слов 1<=n4<=1000.
     */
    private int n1 = random();
    private int n2 = random();
    private int n3 = random();

    private List<String> sentenceList = new ArrayList<>();
    private List<String> paragraphList = new ArrayList<>();


    public void getFiles(String path, int n, int size, String[] words, int probability){
        for (int i = 0; i <= n; i++) {
            try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path+i+".txt"), size)){
                byte[] bytes = paragraphGen(probability,words).getBytes();
                bos.write(bytes);
                bos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * random
     * @return int случайное значение
     */
    private int random() {
        Random random = new Random();
        return random.nextInt(15) + 1;
    }

    /**
     * firstWord
     * @param word - простая строка
     * @return строку с первой загловной буквой
     */
    private String firstWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.setCharAt(0,Character.toUpperCase(word.charAt(0)));
        return sb.toString();
    }

    /**
     * randomString
     * @param count int значение количества символов в 1 слове
     * @return строку слова со случайными символами
     */
    private String randomString(int count) {
        return RandomStringUtils.random(count, true, false).toLowerCase();
    }

    /**
     * sentenceGen
     * @param probability - вероятность вхождения строки из массива в предложение
     * @param words - массив слов для использования в вероятности
     * @return строку в виду предложения
     */
    private String sentenceGen(int probability, String[] words) {
        String[] stringArray = words;
        Random random = new Random();
        double prob = (double) probability;
        for (int i = 0; i <= n1; i++) {
            if(i==0){
                sentenceList.add(firstWord(randomString(n2)));
            }
            sentenceList.add(" ");
            sentenceList.add(randomString(n2));
            sentenceList.add(Math.random()>0.8?",":"");
            if(i==n1){
                if(Math.random()<=(1/prob) || probability==1) {
                    sentenceList.add(" ");
                    sentenceList.add(stringArray[random.nextInt(stringArray.length)]);
                }
                if(Math.random()>0.7) {
                    sentenceList.add("! ");
                } else if(Math.random()>0.3) {
                    sentenceList.add("? ");
                } else {
                    sentenceList.add(". ");
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s: sentenceList) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * paragraphGen
     * @param probability - вероятность вхождения строки из массива в предложение
     * @param words - массив слов для использования в вероятности
     * @return - возвращает n3 предложений в качестве абзаца
     */
    private String paragraphGen(int probability,String[] words) {
        for (int i = 0; i <= n3; i++) {
            paragraphList.add(sentenceGen(probability,words));
            sentenceList.clear();
        }
        StringBuilder sb = new StringBuilder();
        for (String s: paragraphList) {
            sb.append(s);
            sb.append("\n" + "\r");
        }
        return sb.toString();
    }
}
