package algorithm4thedition;

public class Recursion {
    public static void main(String[] args){
    	int i=9;
    	System.out.println(haha(i));
    	System.out.println(fibonaccil(i));
    }
    
    public static int haha(int i){        //递归求阶乘
    	if(i==1)
    		return 1;
    	else 
    		return haha(i-1)*i;
    }
    
    public static int fibonaccil(int i){   // 递归求斐波那契
    	if(i==1||i==2)
    		return 1;
    	else 
    		return fibonaccil(i-1)+fibonaccil(i-2);
    }
}
