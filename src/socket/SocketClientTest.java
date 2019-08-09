package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClientTest {
	public static final String IP = "127.0.0.1";
	public static final int port = 21998;
	private Socket s;

	public SocketClientTest() throws IOException {
		try {
			s = new Socket(IP, port);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void setConnection() throws IOException {

		InputStream is;

		try {
			is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			System.out.println(br.readLine());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws IOException {

		SocketClientTest mc = new SocketClientTest();
		mc.setConnection();

	}
}
