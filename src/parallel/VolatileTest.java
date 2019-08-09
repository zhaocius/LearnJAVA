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

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 100; i++)
			fixedThreadPool.execute(new Runnable() {
				public void run() {

					Count.add();
				}
			});

		while (true) {
			if (Thread.activeCount() == 1) {
				System.out.println(Count.i);
				break;
			}
		}

	}

}
