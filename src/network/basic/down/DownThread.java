package network.basic.down;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownThread implements Runnable {
	
	//当前线程开始下载的位置
	private int startPos;
	//定义当前线程负责下载的文件大小
	private int currentPartSize;
	//当前线程需要下载的文件块
	private RandomAccessFile currentPart;
	//定义该线程已下载的字节数
	public int length;
	
	
	public DownThread(int startPos, int currentPartSize,
			RandomAccessFile currentPart) {
		super();
		this.startPos = startPos;
		this.currentPartSize = currentPartSize;
		this.currentPart = currentPart;
	}


	@Override
	public void run() 
	{
		try {
			HttpURLConnection conn = DownUtil.getConn();
			InputStream inStream = conn.getInputStream();
			//跳过startPos个字节，表明该线程只下载自己负责的那部分文件
			inStream.skip(this.startPos);
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			//读取网络数据，并写入本地文件
			while (length < currentPartSize && (hasRead = inStream.read(buffer)) != -1)
			{
				currentPart.write(buffer,0,hasRead);
				//累计该线程下载的总大小
				length += hasRead;
				
			}
			currentPart.close();
			inStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
