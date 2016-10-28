package multiThread.communication.thirdWay;

import java.util.concurrent.BlockingQueue;

/**
 * @decription 银行账户
 * @version 1.0
 * @date 2016年10月27日上午10:46:05
 * @author lfq
 * 
 */
public class Account {
	
	private String accountNum;//账户
	private int balance = 2;//余额
	//定义容量为1的阻塞队列
	private  BlockingQueue<Integer> queue;//定义容量为1的阻塞队列
		
	public Account() {
		super();
	}
	public Account(String accountNum,BlockingQueue<Integer> queue) {
		super();
		this.accountNum = accountNum;
		this.queue = queue;
	}
	
	//以下两个存取钱的同步方法（都操作共享数据），由多线程来并发操作
	public  void deposit(int balance) throws InterruptedException{
		
		queue.put(1);
		this.balance += balance;//存钱
		System.out.println(Thread.currentThread().getName()+":存"+balance+" 余额"+this.balance);
	}
	
	public  void draw(int balance) throws InterruptedException{
		
		queue.take();	
		this.balance -= balance;//取钱
		System.out.println(Thread.currentThread().getName()+":取"+balance+" 余额"+this.balance);
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
