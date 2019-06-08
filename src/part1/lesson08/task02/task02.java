package part1.lesson08.task02;

import part1.lesson08.task01.Library;
import part1.lesson08.task01.Serial;

public class task02 {
    public static void main(String[] args) {
        Library library1 = new Library("Books1, Books2",new int[]{1,2,3,4,5},true);
        Serial serial = new Serial();
        School school = new School(100,library1,"СОШ52");
        serial.serialize(school,"src\\part1\\lesson08\\task02\\school1.bin");
        System.out.println(serial.deSerialize("src\\part1\\lesson08\\task02\\school1.bin"));
    }
}

//
