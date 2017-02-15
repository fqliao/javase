package network.basic.tcp.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @decription:客户端
 * @version:1.0
 * @date: 2016年11月14日下午8:34:04
 * @author: lfq
 * 
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		Socket s = new Socket("10.170.22.223",8888);
		//将Socket对应的输入流包装成BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line = "";
		while((line = br.readLine()) != null)
		{
			sb.append(line);
		}
		br.close();
		s.close();
		System.out.println(sb.toString());
	}

}
