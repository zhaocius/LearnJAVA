package cc150;

public class A1_1 {
    public static boolean contain(String a){
    	boolean[] test=new boolean[256];
    	for(int i=0;i<a.length();i++){
    		char c=a.charAt(i);
    		if(test[c]==false)
    		    test[c]=true;
    		else
    			return true;
    		
    		
    	}
    	return false;
    	
    		
    }
    
    public static void main(String[] args){
    	String a="faewfaewhaehgaevas";
    	String b="abcde";
    	System.out.println(contain(b));
    	
    	
    }
}

