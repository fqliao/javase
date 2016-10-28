package multiThread.communication.thirdWay;

import java.util.concurrent.BlockingQueue;

/**
 * @decription:取钱线程
 * @version:1.0
 * @date: 2016年10月27日上午11:27:28
 * @author: lfq
 * 
 */
public class DrawThread implements Runnable{
	
	private Account account;
	private int balance;
	
	public DrawThread() {
		super();
	}

	public DrawThread(Account account, int balance) {
		super();
		this.account = account;
		this.balance = balance;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) 
		{
			try {
				account.draw(balance);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
