import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args){
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.remove();

        System.out.println(queue.toString());

    }
}
