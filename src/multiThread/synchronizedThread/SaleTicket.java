package multiThread.synchronizedThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @decription:三种同步方式
 * @version:1.0
 * @date: 2016年10月24日下午5:10:30
 * @author: lfq
 * 
 */
public class SaleTicket {
	
	private static int ticketNums = 5;//有一百张票
	
	private static final ReentrantLock lock = new ReentrantLock();//Lock对象 实现同步
//	public synchronized static void sale(int saleNums)//synchronized修改方法
	public  static void sale(int saleNums)
	{
//		synchronized (SaleThread.class) //synchronized代码块
//		{
			lock.lock();
			try
			{
				if(saleNums < 1)
					System.out.println("请买一张票");
				
				if(ticketNums > 0 && ticketNums >= saleNums)
				{
					ticketNums -= saleNums;
					System.out.println("卖出"+saleNums+"张票，"+"还剩"+ticketNums+"张票");
				}
				else if(ticketNums > 0 && ticketNums < saleNums)
				{
					System.out.println("余票只有"+ticketNums+"张，不够购买"+saleNums+"张票");
				}
				else
				{
					System.out.println("票已售空！");
				}
				
			}
			finally
			{
				lock.unlock();
			}
//		}
	}

	public static int getTicketNums() {
		return ticketNums;
	}
	
}
