package learnjava;

public class ArrayReverseTest {
    public static void main(String[] args){
    	System.out.println(reverse("abcdefg"));
    }
    public static String reverse(String a){
    	if(a.length()==1)
    		return a;
    	else{
    		String right=a.substring(a.length()/2);
    		String left=a.substring(0, a.length()/2);
    		return reverse(right)+reverse(left);
    	}
    }
}
