package parallel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest{
    CyclicBarrier cyclicBarrier;
    public void test(){
        cyclicBarrier=new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("三个人都已到达会议室");
                System.out.println("Thread name = "+Thread.currentThread().getName());

            }
        });
        System.out.println("this thread gogogo , Thread name = "+Thread.currentThread().getName());

//        定义三个线程，相当于三个参会的人
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random()*5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第"+Thread.currentThread().getName()+"个人到达会议室");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"开始开会");
                }
            }, String.valueOf(finalI)).start();
        }


    }
    public static void main(String[] arags){
        CyclicBarrierTest test = new CyclicBarrierTest();
        test.test();
    }
}
