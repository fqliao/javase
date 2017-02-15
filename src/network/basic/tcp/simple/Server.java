package network.basic.tcp.simple;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @decription:服务器端
 * @version:1.0
 * @date: 2016年11月14日下午8:25:15
 * @author: lfq
 * 
 */
public class Server {
	
	public static void main(String[] args) throws IOException
	{
		InetAddress ip = Inet4Address.getByName("10.170.22.223");
		//创建一个ServerSocket，用于监听客户端的连接请求
		ServerSocket ss = new ServerSocket(8888,4,ip);
		//采用循环不断地接收来自客户端的请求
		while(true)
		{
			//每当接收到客户端Socket的请求时，服务器端也对应产生一个Socket
			Socket s = ss.accept();
			//将Socket对应的输出流包装成PrintStream
			PrintStream ps = new PrintStream(s.getOutputStream());
			//进行普通IO操作
			ps.print("恭喜，2017新年快乐！");
			//关闭输出流，关闭Socket
			ps.close();
			s.close();
		}
		
	}
}
