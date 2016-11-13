package network.basic.down;

import java.io.IOException;

public class Client {

	public static void main(String[] args) throws IOException, InterruptedException {
		//初始化DownUtil对象
		final DownUtil downUtil = new DownUtil("https://gd3.alicdn.com/"
				+ "imgextra/i3/766781288/TB2yq33ak1M.eBjSZFFXXc3vVXa_!!766781288.jpg",
				"movie.jpg",4);
		//开始下载
		downUtil.download();
		while (downUtil.getCompleteRate() < 1) 
		{
			//每隔1ms查询一次任务的完成进度
			//GUI程序中可根据该进度来绘制进度条
			System.out.println("已完成："+downUtil.getCompleteRate());
			Thread.sleep(1);
		}
	}

}
