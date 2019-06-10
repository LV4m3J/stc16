package part1.lesson08.task01;

public class Task01 {
    public static void main(String[] args) {
        Serial serial = new Serial();
        Library library1 = new Library("Books1, Books2",new int[]{1,2,3,4,5},true);
        serial.serialize(library1,"src\\part1\\lesson08\\task01\\library1.bin");
        System.out.println(serial.deSerialize("src\\part1\\lesson08\\task01\\library1.bin"));
    }
}