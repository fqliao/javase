package network.basic.tcp.multiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @decription:服务器
 * 负责接收客户端连接请求，接收到请求之后将对于的Socket放入List，并开启一个线程为处理该Socket的通信
 * @version:1.0
 * @date: 2016年11月14日下午9:20:49
 * @author: lfq
 * 
 */
public class Server {
	
	//定义保存所有Socket的ArrayList,并将其包装为线程安全的
	public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
	
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		while(true)
		{
			//此行代码会阻塞，将一直等待客户端的连接
			Socket s = ss.accept();
			//运行到这句，说明有客户端连接过来了，将创建的Socket连接加入List
			socketList.add(s);
			//每当客户端连接成功后启动一个ServerThread线程为该客户端服务
			new Thread(new ServerThread(s)).start();
		}

	}
	
}
