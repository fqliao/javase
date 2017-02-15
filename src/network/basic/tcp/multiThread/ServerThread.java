package network.basic.tcp.multiThread;
import java.io.*;
import java.net.*;
public class ServerThread implements Runnable{
	
	//定义当前线程处理的Socket
	private Socket s;
	//定义当前线程处理Socket对于的输入流
	private BufferedReader br;
	
	public ServerThread(Socket s) throws IOException
	{
		this.s = s;
		//初始化该Socket对应的输入流
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() 
	{
		String content = "";
		//采用循环不断地从Socket中读取客户端发送过来的数据nt
		try {
			while((content = readFromClient()) != null)
			{
				//遍历SocketList中每个Socket,将读取客户端发送过来的数据，将读到的内容向每个Socket
				for(Socket s : Server.socketList)
				{
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//读取客户端数据的方法
	private String readFromClient()
	{
		try {
			return br.readLine();
		} catch (IOException e) {//若捕获到异常，则表明对应的客户端已经关闭，移除Socket
			Server.socketList.remove(s);
		}
		return null;
	}
}
