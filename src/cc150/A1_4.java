package cc150;

public class A1_4 {
	public static boolean call(String a,String b){
		if(a==null||b==null) return false;
		if(a.length()!=b.length()) return false;
		int[] flag=new int[256];
		for(int i=0;i<a.length();i++){
			flag[a.charAt(i)]++;
			flag[b.charAt(i)]--;
		}
		
		for(int k=0;k<flag.length;k++){
			if(flag[k]!=0)
				return false;
			
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String a="abcd";
        String b="cbda";
        System.out.println(call(a,b));
	}

}
