import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("threeone");
        list.add("onetwothree");
        list.add("oontwthreee");
        list.add("neowthree");

        ComplexWordCountServer server = new ComplexWordCountServer(3, list);
        server.countSpecialString();
        System.out.println(server.toString());
    }
}
