package cc150;

import java.util.*;

public class A3_5 {
	public static Stack<Integer> stack1 = new Stack<Integer>();
	public static Stack<Integer> stack2 = new Stack<Integer>();

	public static void push(int num) {
		stack1.push(num);
	}

	public static int pop() {
		if (stack1.size() == 0 && stack2.size() == 0)
			return 0;

		if (stack2.size() == 0) {
			while (stack1.size() != 0)
				stack2.push(stack1.pop());
			return stack2.pop();
		} else {
			return stack2.pop();
		}

	}

	public static void main(String[] args) {
		A3_5 a = new A3_5();
		a.push(1);
		a.push(2);
		a.push(3);
		System.out.println(a.pop());
		a.push(4);
		a.push(5);
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		
		
		
	}

}
