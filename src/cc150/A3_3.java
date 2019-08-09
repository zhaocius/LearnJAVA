package cc150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A3_3 {
	List<Stack<Integer>> list = new ArrayList<Stack<Integer>>();
	
	public void insert(int a) {
		Stack<Integer> last = this.getLastStack();
		if (last != null && last.size() < 3) {
			last.push(a);
		} else {
			last = new Stack<Integer>();
			last.push(a);
			list.add(last);
		}
	}

	public Integer extract() {
		Stack<Integer> last = this.getLastStack();
		Integer a = last.pop();
		if (last.size() == 0)
			list.remove(list.size() - 1);

		return a;

	}

	private Stack<Integer> getLastStack() {
		if (list.size() == 0)
			return null;
		return list.get(list.size() - 1);

	}

	public static void main(String args[]) {
		

	}

}
