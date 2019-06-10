package part1.lesson04.task02;

public class Task02 {
    public static void main(String[] args) {
        ObjectBox ob = new ObjectBox();
        ob.addObject(new Object());
        ob.addObject("some body once told me");
        ob.addObject(1);
        ob.addObject(1.1);
        ob.addObject(false);
        ob.dump();
        ob.deleteObject(1);
        ob.dump();
    }
}