package cc150;

public class A1_3 {
	public static void call(String a) {
		for (int i = 0; i < a.length(); i++) {
			for (int j = i + 1; j < a.length(); j++) {
				if (a.charAt(i) == a.charAt(j)) {
					a = a.substring(0, j) + a.substring(j + 1);
					j--;
				}
			}
		}
		System.out.println(a);
	}

	public static void main(String[] args) {

		String a = new String("acaabaaa");

		call(a);
	}

}
