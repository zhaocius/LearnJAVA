package cc150;

import java.util.*;

public class A3_6 {
	public static Stack<Integer> temp = new Stack<Integer>();
	
	public static void sort(Stack<Integer> stack){
		while(!stack.isEmpty()){
			int num=stack.pop();
			while(temp.size()!=0&&num>temp.peek()){
				stack.push(temp.pop());
			}
			temp.push(num);
		}
	}

	public static void main(String[] args) {
	   A3_6 a=new A3_6();
	   Stack<Integer> stack= new Stack<Integer>();
	   stack.push(1);
	   stack.push(3);
	   stack.push(5);
	   stack.push(7);
	   stack.push(9);
	   stack.push(2);
	   stack.push(4);
	   stack.push(6);
	   stack.push(8);
	   a.sort(stack);
	   System.out.println(Arrays.toString(temp.toArray()));
		
		
		
	}

}
