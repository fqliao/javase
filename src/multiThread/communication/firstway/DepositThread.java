package multiThread.communication.firstway;

/**
 * @decription:存钱线程
 * @version:1.0
 * @date: 2016年10月27日上午11:27:16
 * @author: lfq
 * 
 */
public class DepositThread implements Runnable{
	
	private Account account;
	private int balance;
	
	
	public DepositThread() {
		super();
	}

	public DepositThread(Account account, int balance) {
		super();
		this.account = account;
		this.balance = balance;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) 
		{
			account.deposit(balance);
		}
	}

}
