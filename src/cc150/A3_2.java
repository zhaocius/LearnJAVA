package cc150;

import java.util.Stack;

public class A3_2 extends Stack<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Stack<Integer> s;

	public A3_2() {
		s = new Stack<Integer>();

	}

	public void push(int value) {
		if (value <= min())
			s.push(value);
	    super.push(value);

	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s.pop();
		}
		return value;

	}
	
	public Integer min(){
		if(s.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return s.peek();
		}
		
	}
	
	public static void main(String args[]){
		A3_2 a=new A3_2();
		a.push(3);
		a.push(4);
		a.push(2);
		a.pop();
		System.out.println(a.min());
		
	}

		

}
