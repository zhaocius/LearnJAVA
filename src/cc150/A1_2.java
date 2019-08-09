package cc150;

public class A1_2 {
	public static String reverse(String str){
		if(str.length()<=1)
			return str;
		String left=str.substring(0, str.length()/2);
		String right=str.substring(str.length()/2, str.length());
		return reverse(right)+reverse(left);
	}
	
	public static void main(String[] args){
		String a="abcde";
		System.out.println(reverse(a));
		
	}

}
