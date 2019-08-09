package algorithm4thedition;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 44, 67, 987, 5, 6, 7, 8, 9 };
		Arrays.sort(a);
		System.out.println(find1(a,44));

	}

	public static int find(int[] a, int b) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] > b)
				hi = mid - 1;
			else if (a[mid] < b)
				lo = mid + 1;
			else
				return mid;
		}
		return -1;

	}

	public static int find1(int[] a, int k) {
		return find2(a, 0, a.length - 1, k);
	}

	public static int find2(int[] a, int lo, int hi, int key) {
		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (a[mid] > key)
			return find2(a, lo, mid - 1, key);
		else if (a[mid] < key)
			return find2(a, mid + 1, hi, key);
		else
			return mid;

	}

}
