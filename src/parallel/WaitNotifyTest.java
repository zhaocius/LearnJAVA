package parallel;

public class WaitNotifyTest {
	private volatile int val = 1;

	private synchronized void printAndIncrease() {
		System.out.println(Thread.currentThread().getName() + " prints " + val);
		val++;
	}

	// print 1,2,3 7,8,9
	class PrinterA implements Runnable {
		@Override
		public void run() {
			while (val <= 3) {
				printAndIncrease();
			}
			// print 1,2,3 then notify printerB
			synchronized (WaitNotifyTest.this) {
				WaitNotifyTest.this.notify();
                System.out.println("打印完前三个数字，notify，但不释放锁");
			}
			try {
				synchronized (WaitNotifyTest.this) {
					System.out.println("打印完前三个数字，放弃当前锁，进入等待");
					WaitNotifyTest.this.wait();
					System.out.println("从wait处继续执行");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("打印后三个数字");
			while (val <= 9) {
				printAndIncrease();
			}
		}
	}

	// print 4,5,6 after printA print 1,2,3
	class PrinterB implements Runnable {
		@Override
		public void run() {
			synchronized (WaitNotifyTest.this) {
				try {
					System.out.println("PrinterB拿到锁，阻塞");
					WaitNotifyTest.this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (val <= 6) {
				printAndIncrease();
			}
			synchronized (WaitNotifyTest.this) {
				System.out.println("PrinterB 通知线程A");
				WaitNotifyTest.this.notify();
			}
		}
	}

	public static void main(String[] args) {
		WaitNotifyTest demo = new WaitNotifyTest();
		demo.doPrint();
	}

	private void doPrint() {
		Thread a = new Thread(new PrinterA(), "printerA");
		Thread b = new Thread(new PrinterB(), "printerB");
		// 必须让b线程先执行，否则b线程有可能得不到锁，执行不了wait，而a线程一直持有锁，会先notify.
		b.start();
		a.start();

	}
}