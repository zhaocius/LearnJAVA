package learnjava;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockTest {
	public static void main(String[] agrs) {
		Block block = new Block();
//		block.takeAndPull();
		block.addAndPutAndOffer();
	}
}

class Block {
	public LinkedBlockingQueue<Integer> a = new LinkedBlockingQueue<Integer>();
	public LinkedBlockingQueue<Integer> b = new LinkedBlockingQueue<Integer>(2);

	public void addAndPutAndOffer(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<3;i++){
					try {
						// add非阻塞，直接报错，put是阻塞的，不占用cpu，offer非阻塞，直接返回false
//						boolean result=b.add(1);
//					    b.put(1);
					    boolean result=b.offer(i);
						System.out.println("invoke");
					} catch (Exception e) {
						e.printStackTrace();  
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
					try {
						Thread.sleep(2000);
						System.out.println("我取了 == "+b.take());
						System.out.println("我取了 == "+b.take());
						System.out.println("我取了 == "+b.take());
					} catch (Exception e) {
						e.printStackTrace();  
					}
				}
		}).start();
		
	}
	public void takeAndPull() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(3000);
						a.add(1);
					} catch (Exception e) {
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						// take是阻塞的，不占用cpu，poll非阻塞，直接占满了
						System.out.println("invoke");
						a.take();
						// a.poll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}