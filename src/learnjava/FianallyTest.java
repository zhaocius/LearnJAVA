package learnjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FianallyTest {

	public static void main(String[] arags) {
		System.out.println(test());
	}

	public static int test() {
		int x = 1;
		try {
			x++;
			return x;
		} finally {
			x++;
			return x; // 如果没有 return 结果为2，如果有，结果为3，所以finally中最好不要写return。
		}
	}

}
