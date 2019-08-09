package parallel;

import java.util.concurrent.ArrayBlockingQueue;

public class WaitNotifyConsumerProducerTest {
    private ArrayBlockingQueue<String> apple = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        WaitNotifyConsumerProducerTest demo = new WaitNotifyConsumerProducerTest();
        try {
            demo.doPrint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void produce() {
        synchronized (this) {
            while (apple.remainingCapacity() == 0) {
                try {
                    this.wait();
                } catch (Exception e) {
                }
            }
            apple.add(new String("a "));
            System.out
                    .println(Thread.currentThread().getName() + " produce " + apple.toString());
            this.notifyAll();
        }
    }

    private void consume() {
        synchronized (this) {
            while (apple.isEmpty()) {
                try {
                    this.wait();
                } catch (Exception e) {

                }
            }

            System.out.println(Thread.currentThread().getName() + " consume " + apple.remove());
            this.notifyAll();
        }
    }

    private void doPrint() throws InterruptedException {
        Thread a = new Thread(new PrinterA(), "Producer");
        Thread b = new Thread(new PrinterB(), "Consumer_A");
        Thread c = new Thread(new PrinterB(), "Consumer_B");
        // 必须让b线程先执行，否则b线程有可能得不到锁，执行不了wait，而a线程一直持有锁，会先notify

        b.start();
        c.start();
        a.start();
    }


    class PrinterA implements Runnable {
        int count = 50;
        @Override
        public void run() {
            while (count-- > 0) {
                produce();
            }
        }
    }

    class PrinterB implements Runnable {
        int count = 50;
        @Override
        public void run() {
            while (count-- > 0) {
                consume();
            }
        }

    }
}


