package algorithm4thedition;

public class FibonacciTest {
    public static void main(String[] args){
    	System.out.println(fibo(6));
    }
    public static int fibo(int a){
    	if(a==1||a==2)
    		return 1;
    	else
    		return fibo(a-1)+fibo(a-2);
    }
    
}
