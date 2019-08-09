package cc150;

public class A3_1{
	int size=10;
	int[] buffer=new int[size*3];
	int[] stackpoint ={0,0,0};
	
	void push(int stacknum,int value){
		int index=stacknum*size+stackpoint[stacknum]++;
		buffer[index]=value;
	
	}
	
	int pop(int stacknum){
		int index=stacknum*size+--stackpoint[stacknum];
		int value=buffer[index];
		return value;
		
		
	}
	
	public static void main(String[] args){
		A3_1 a=new A3_1();
		a.push(2,100);
		a.push(2,200);
		System.out.println(a.pop(2));
		System.out.println(a.pop(2));	
	}
	
	
	
	
}