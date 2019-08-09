package learnjava;

public class StaticTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Father person0=new Son();
       person0.call();
       Father person1=new Father();
       person1.call();
       Son person2=new Son();
       person2.call();
	}

}

class Father{
	public static void call(){
		System.out.println("father");
	}

}
class Son extends Father{
	public static void call(){
		System.out.println("son");
	}

}


