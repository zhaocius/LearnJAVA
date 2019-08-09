package socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
/**
 * 将来自客户端的信息加工一下送回去
 * 
 * @author xusucheng
 * @create 2017-12-21
 **/
public class SocketServerTest {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(21998);
		// 服务端在21998端口监听客户端请求的TCP连接
		Socket client = null;
		boolean f = true;
		while (f) {
			client = server.accept();
			// 服务端在调用accept（）等待客户端的连接请求时会阻塞，直到收到客户端发送的连接请求才会继续往下执行代码
			// 链接成功后为每个客户端连接开始做出处理
			try {
				PrintStream out = new PrintStream(client.getOutputStream());
				// 获取Socket的输出流，用来向客户端发送数据
				BufferedReader buf = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				// 获取Socket的输入流，用来接收从客户端发送过来的数据
				boolean flag = true;
				while (flag) {
					String str = buf.readLine();
					// 接收从客户端发送过来的数据
					if (str == null || "".equals(str)) {
						flag = false;
					} else {
						// if ("bye".equals(str)) {
						// flag = false;
						// } else {
						// 将接收到的字符串前面加上echo，发送到对应的客户端
						// out.println("echo:" + str);
						// }
						System.out.println();
						out.println(str);
					}
				}
				out.close();
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		server.close();
	}

}



