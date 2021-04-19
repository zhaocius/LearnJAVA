package parallel;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	public static AtomicInteger value = new AtomicInteger(0);
	public static final int THREAD_COUNT = 20;

	public static void increase() {
		value.incrementAndGet();

	}

	static class MyThread implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++)
				increase();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(new MyThread()).start();

		}
		while(true){
			if(Thread.activeCount()==1){
			    System.out.println(value);
			    break;
			}
		}

	}

}
