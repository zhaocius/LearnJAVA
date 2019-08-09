package parallel;

public class StringLockTest {

	private String locka="a";
	private String lockb="a";
	private int a=0;
	
	public void operatea() {
		synchronized(locka) {
			a++;
			System.out.println(""+a);
		}
	}
	public void operateb() {
		synchronized(lockb) {
			a++;
			System.out.println(""+a);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final StringLockTest slta=new StringLockTest();
		final StringLockTest sltb=new StringLockTest();
		new Thread() {
			@Override
			public void run() {
			   while(true) {
				   
				   try{
					   Thread.sleep(2000);
					   slta.operatea();
				   }catch(Exception e) {
					   
				   }
				   
			   }
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
			   while(true) {
				   
				   try{
					   Thread.sleep(100);
					   sltb.operateb();
				   }catch(Exception e) {
					   
				   }
				   
			   }
			}
		}.start();

	}
	

}
