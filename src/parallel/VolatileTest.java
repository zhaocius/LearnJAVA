package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest {

    static class Count {
        public volatile static int i = 0;
        public static void add() {
            i++;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
           new Thread(new Runnable() {
                public void run() {

                    Count.add();
                }
            }).start();
        }


        //volatile无法保证原子性。
        while (true) {
            if (Thread.activeCount() == 1) {
                System.out.println(Count.i);
                break;
            }
        }

    }

}
