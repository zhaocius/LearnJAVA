package parallel;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockTest {
   public static void transfer(Count from,Count to,int money){
	   synchronized(from){
		   synchronized(to){
			   from.money-=money;
			   to.money+=money;
			   System.out.println(money);
		   }

	   }
   }
   
   public static void safetyTransfer(Count from,Count to,int money){
	   int hashFrom=System.identityHashCode(from);
	   int hashTo=System.identityHashCode(to);
	   final Object a=new Object();
	   if(hashFrom>hashTo){
		   synchronized(from){
			   synchronized(to){
				   from.money-=money;
				   to.money+=money;
				   System.out.println(money);
			   }
		   }
	   }else if(hashFrom<hashTo){
		   synchronized(to){
			   synchronized(from){
				   from.money-=money;
				   to.money+=money;
				   System.out.println(money);
			   }
		   }
	   }else{
		   synchronized(a){
			   synchronized(from){
				   synchronized(to){
					   from.money-=money;
					   to.money+=money;
					   System.out.println(money);
				   }
			   }
		   }
		   
	   }
	   
   }
   public static void main(String[] args){
	   final Random random=new Random();
	   final int countNum=5;
	   final int threadNum=10;
	   final int transferTime=10000;
	   final Count[] c=new Count[countNum];
	   for(int i=0;i<countNum;i++){
		   c[i]=new Count();
	   }
	   
	   ExecutorService es=Executors.newCachedThreadPool();
	   for(int i=0;i<threadNum;i++){
		   es.execute(new Runnable(){
			   public void run(){
				   for(int i=0;i<transferTime;i++){
					   safetyTransfer(c[random.nextInt(countNum)],c[random.nextInt(countNum)],random.nextInt(1000));
				   }
			   }
		   });
	   }

  
   }
}

class Count{
	public int money;
	
}