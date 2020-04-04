package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {
	private static final int BSIZE=1024*1024*1024;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			FileChannel fc;		
			fc=new FileInputStream("a").getChannel();
			ByteBuffer buff=ByteBuffer.allocate(BSIZE);
			fc.read(buff);
			buff.flip();
			int i=0;
			while(buff.hasRemaining()&&i<6){
				i++;
			 System.out.println((short)buff.get());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
