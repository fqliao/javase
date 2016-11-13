package network.basic;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;

/**
 * @decription:InetAddress测试 测试网络连通性
 * @version:1.0
 * @date: 2016年11月4日下午3:41:10
 * @author: lfq
 * 
 */
public class InetAddressTest {

	public static void main(String[] args) throws IOException {
		
		//根据主机名获取对应的InetAddress实例
		InetAddress baidu1 = Inet4Address.getByName("www.baidu.com");
		System.out.println(baidu1.getHostAddress());//获得字符串型的IP地址
		System.out.println(Arrays.toString(baidu1.getAddress()));//获得字节型的IP地址
		System.out.println(baidu1.isReachable(2000));//测试网络连通性
		
		//根据IP地址获取对应的InetAddress实例
		byte[] addr = {127,0,0,1};
		InetAddress baidu2 = Inet4Address.getByAddress(addr);
		System.out.println(baidu2.getHostName());
		
		//获取本机的InetAddress实例
		InetAddress local = Inet4Address.getLocalHost();
		System.out.println(local.getHostAddress());
		System.out.println(local.getHostName());
		System.out.println(Arrays.toString(local.getAddress()));
	}

}
