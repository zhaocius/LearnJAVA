package parallel;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SynchronizedListTest {
	public static void main(String[] args){
		List<String> list = Collections.synchronizedList(new LinkedList<String>());
		list.add("a");
		list.remove(0);
	}

}
