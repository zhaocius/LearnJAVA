package parallel;

import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
    private static AtomicInteger count = new AtomicInteger(0);

    private static int increase(){
        for(;;){
            int currentValue = count.get();
            int  next  =  currentValue  +   1 ;
            if  (count.compareAndSet(currentValue, next))
                return  next;
        }

    }
    private static void testAtomicInteger() {
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    System.out.println(count.incrementAndGet());
                    System.out.println(increase());

                }
            }).start();
        }

        while (true) {
            if (Thread.activeCount() == 1) {
                System.out.println("total : " + count);
                break;
            }
        }
    }


    public static void main(String[] args) {
        CASTest.testAtomicInteger();

    }
}
