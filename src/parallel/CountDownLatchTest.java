package parallel;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchTest {
    public static CountDownLatch countDownLatch;

    public static void test1(){
        countDownLatch=new CountDownLatch(5);

        for (int i = 0; i < 5; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(5) * 1000);
                    } catch (Exception e) {

                    }
                    System.out.println(Thread.currentThread().getName() + " done");
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + " done done");

                }
            }, "Thread " + i).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread begin 1");
    }

    public static void test2(){
        countDownLatch=new CountDownLatch(1);

        for (int i = 0; i < 5; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " block");
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " done");
                }
            }, "Thread " + i).start();

        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (Exception e) {

        }
        countDownLatch.countDown();
        System.out.println("work thread begin 2");
    }

    public static void main(String[] args) {
        CountDownLatchTest.test1();
        CountDownLatchTest.test2();


    }

}
