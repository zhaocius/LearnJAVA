package cc150;

public class A8_2 {
    public static void main(String[] args){
    	System.out.println(path(9,9));
    	
    }
    
    public static int path(int n,int m){
    	if(n==1||m==1)
    		return 1;
    	else 
    		return path(n,m-1)+path(n-1,m);
    }
}
