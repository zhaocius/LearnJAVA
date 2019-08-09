package parallel;

public class SynchronizedTest {
	public static void main(String[] args) {
		Ticket t = new Ticket();// 创建一个线程任务对象。

		// 创建4个线程同时卖票
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		// 启动线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Ticket implements Runnable {
	// 当前拥有的票数
	private int num = 100;

	public void run() {
		while (true) {
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
}