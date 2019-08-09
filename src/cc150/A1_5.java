package cc150;
public class A1_5 {
	public static String call(String a){
		int N=a.length();
		int BlankCount=0;
		for(int i=0;i<N;i++){
			if(a.charAt(i)==' ')
				BlankCount++;
		}
		char[] str=new char[N+BlankCount];
		for(int i=N-1;i>=0;i--){
			if(a.charAt(i)!=' '){
				str[i+BlankCount]=a.charAt(i);
			}else{
				str[i+BlankCount]='%';
				str[i+--BlankCount]='2';
				
				
			}
			
		}
		return new String(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String a="i am zhaozi";
      
        System.out.println(call(a));
	}

}
