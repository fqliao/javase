package network.basic.down;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @decription:多线程下载工具类
 * @version:1.0
 * @date: 2016年11月4日下午5:26:23
 * @author: lfq
 * 
 */
public class DownUtil {
	
	//定义下载资源的路径
	private static String path;
	//指定下载资源的保存位置
	private String targetFile;
	//定义下载的线程数
	private int threadNum;
	//定义下载的线程对象
	private DownThread[] threads;
	//定义下载文件的总大小
	private int fileSize;
	public DownUtil(String path, String targetFile, int threadNum) {
		super();
		DownUtil.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
		//初始化threads数组
		this.threads = new DownThread[threadNum];
	}
	
	public void download() throws IOException
	{	
		//打开连接
		HttpURLConnection conn = getConn();
		
		//得到文件大小
		fileSize = conn.getContentLength();
		conn.disconnect();
		
		//创建本地文件 并设置本地文件大小为下载文件大小
		RandomAccessFile file = new RandomAccessFile(targetFile,"rw");
		file.setLength(fileSize);
		file.close();
		
		//分配每个线程下载的文件块大小
		int currentPartSize = fileSize / threadNum + 1;
		for (int i = 0; i < threadNum; i++)
		{
			//计算每个线程下载的开始位置
			int startPos = i * currentPartSize;
			//每个线程使用一个RandomAccessFile进行下载
			RandomAccessFile currentPart = new RandomAccessFile(targetFile,"rw");
			//定位该线程的下载位置
			currentPart.seek(startPos);
			//创建下载线程
			threads[i] = new DownThread(startPos, currentPartSize, currentPart);
			//启动下载线程
			new Thread(threads[i]).start();
		}
		
	}

	public static  HttpURLConnection getConn() throws MalformedURLException,
			IOException, ProtocolException {
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Connection", "Keep-Alive");
		return conn;
	}
	
	//获取下载的百分比
	public double getCompleteRate()
	{
		//统计多个线程已经下载的总大小
		int sumSize = 0;
		for (int i = 0; i < threadNum; i++) 
		{
			sumSize += threads[i].length;
		}
		//返回已经完成的百分比
		return sumSize * 1.0 / fileSize;
	}
	
	
}
