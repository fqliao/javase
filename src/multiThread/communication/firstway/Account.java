package multiThread.communication.firstway;

/**
 * @decription:银行账户
 * @version:1.0
 * @date: 2016年10月27日上午10:46:05
 * @author: lfq
 * 
 */
public class Account {
	
	private String accountNum;//账户
	private int balance;//余额
	private boolean flag = false;//存取钱线程通信的标识
	
	public Account() {
		super();
	}
	public Account(String accountNum) {
		super();
		this.accountNum = accountNum;
		this.balance = 0;
	}
	
	//以下两个存取钱的同步方法（都操作共享数据），由多线程来并发操作
	public synchronized void deposit(int balance){
		if(!flag)
		{
			this.balance += balance;//存钱
			System.out.println(Thread.currentThread().getName()+":存"+balance+" 余额"+this.balance);
			this.flag = true;//允许取钱
			notifyAll();//唤醒其他所有线程(让其他线程来取钱)
		}
		else
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void draw(int balance){
		if(flag)
		{
			this.balance -= balance;
			System.out.println(Thread.currentThread().getName()+":取"+balance+" 余额"+this.balance);
			this.flag = false;//允许存钱
			notifyAll();//唤醒其他线程（来存钱）
		}
		else
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public int getBalance() {
		return balance;
	}
	
}
