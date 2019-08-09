package cc150;

public class A1_8 {
	public static boolean call(String a,String b){
		 a=a+a;
		 //其实应该是调用题目虚拟的isSubstring()方法，但是这里string并没有这个方法，故随便写一个。
		 if(b.equals(a)) 
			 return true;
		 return false;		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String a="applewater";
        String b="erapplewat";
        call(a,b);
      
  
	}

}
