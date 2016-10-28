package multiThread.communication.thirdWay;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @decription:测试线程通信，阻塞队列，测试还有问题
 * @version:1.0
 * @date: 2016年10月27日上午11:31:16
 * @author: lfq
 * 
 */
public class Client {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
		Account account = new Account("0101",queue);
		DepositThread depositThread = new DepositThread(account, 10);
		DrawThread drawThread = new DrawThread(account, 10);
		

		new Thread(drawThread).start();
		new Thread(depositThread).start();
//		new Thread(depositThread).start();
//		new Thread(depositThread).start();

	}

}
