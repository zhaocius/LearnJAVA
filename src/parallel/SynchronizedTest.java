package parallel;

public class SynchronizedTest extends Thread{
    private Ticket ticket;
    public SynchronizedTest(Ticket ticket, String name ){
        super(name);
        this.ticket=ticket;
    }
    @Override
    public void run() {
        for(int i = 0 ;i< 30;i++){
            ticket.sale();
        }
    }

    public static void main(String[] args) {
        Ticket t = new Ticket();// 创建一个线程任务对象。

        // 创建4个线程同时卖票
        Thread t1 = new SynchronizedTest(t,"1");
        Thread t2 = new SynchronizedTest(t,"2");
        Thread t3 = new SynchronizedTest(t,"3");
        Thread t4 = new SynchronizedTest(t,"4");
        // 启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class Ticket {
    // 当前拥有的票数
    private int num = 100;

    public void sale() {
        synchronized (this) {
            if (num > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                // 输出卖票信息
                System.out.println(Thread.currentThread().getName()
                        + ".....sale...." + num--);
            }
        }
    }
}