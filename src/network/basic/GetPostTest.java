package network.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {

	public static void main(String[] args) throws IOException {
		//发送GET请求
		String reuslt1 = sendGet("http://dict.baidu.com/s","wd=java");
		System.out.println(reuslt1);
		//发送POST请求
		String reuslt2 = sendPost("http://dict.baidu.com/s", "wd=java");
		System.out.println(reuslt2);
	}
	
	/**
	 * 向指定URL发送GET方式请求
	 * @param url
	 * @param param 请求参数格式要求name1=value1&name2=value2
	 * @return result 远程资源的响应
	 * @throws IOException
	 */
	public static String sendGet(String url,String param) throws IOException
	{
		StringBuilder result = new StringBuilder();//访问结果
		
		String urlName = url + "?" + param;
		URL realUrl = new URL(urlName);
		//打开和URL之间的连接
		URLConnection conn = realUrl.openConnection();
		//设置通用的请求属性
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1)");
		//建立实际连接
		conn.connect();
		
		//获取所有的响应头字段
		Map<String, List<String>> map = conn.getHeaderFields();
		for (String key : map.keySet()) 
			System.out.println(key+" = "+ map.get(key));
		//定义BufferedReader输入流读取URL的响应
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
		String line;
		while((line = in.readLine()) != null)
			result.append("\n" + line);
		
		return result.toString();
	}
	
	/**
	 * 向指定URL发送POST请求
	 * @param url 发送请求的URL
	 * @param param 请求参数，格式满足name1=value1&name2=value2
	 * @return result 获取远程资源的响应
	 * @throws IOException
	 */
	public static String sendPost(String url,String param) throws IOException
	{
		StringBuilder result = new StringBuilder();
		
		URL realUrl = new URL(url);
		//打开URL的连接
		URLConnection conn = realUrl.openConnection();
		//设置通用属性
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1)");
		
		//发送POST请求必须设置如下两行
		conn.setDoOutput(true);
		conn.setDoInput(true);
		//首先获取URLConnection对象对应的输出流 注意：post,首先必须输出参数，然后输入结果，先出 后入
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		//发送请求参数
		out.print(param);
		//输出流的缓冲
		out.flush();
		
		//获取URLConnection对象的输入流，读取响应
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = "";
		while((line = in.readLine()) != null)
			result.append("\n"+line);
		
		return result.toString();
	}

}
