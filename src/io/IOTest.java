package io;

import java.io.FileInputStream;

public class IOTest {
	private static final int BSIZE = 1024 * 1024 * 1024;

	public static void main(String[] args) throws Exception {

		FileInputStream fr = new FileInputStream("a");
		byte[] buf = new byte[BSIZE];
		int len = fr.read(buf);
		System.out.println(""+len);
		fr.close();
		for (int i = 0; i < 6; i++) {
			System.out.println((short) buf[i] + " i == " + i);
		}

	}
}