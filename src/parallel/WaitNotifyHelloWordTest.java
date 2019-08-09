package parallel;

public class WaitNotifyHelloWordTest {
	public int value = 0;

	private synchronized void helloWord() {
			System.out.println("    hello   " + Thread.currentThread().getName());
			value++;
			if (value < 5) {
				try {		
					wait();
				} catch (Exception e) {
				}
			}
			try {
				System.out.println("     word   " + Thread.currentThread().getName());
				notify();		
			} catch (Exception e) {

			}
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final WaitNotifyHelloWordTest test = new WaitNotifyHelloWordTest();
		for (int i = 0; i < 5; i++) {
			new Thread() {
               @Override
               public void run() {
            	       test.helloWord();
               }
			}.start();
		}

	}

}
