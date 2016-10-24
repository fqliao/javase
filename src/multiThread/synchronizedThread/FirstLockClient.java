package multiThread.synchronizedThread;

/**
 * @decription:三种同步方法，实现多线程对共享资源的并发访问
 * @version:1.0
 * @date: 2016年10月24日下午3:37:47
 * @author: lfq
 * 
 */
public class FirstLockClient{
	
	
	public static void main(String[] args) {
		System.out.println("总票数"+SaleTicket.getTicketNums());
		new Thread(new SaleThread(1)).start();
		new Thread(new SaleThread(2)).start();
		new Thread(new SaleThread(1)).start();
		new Thread(new SaleThread(2)).start();

	}

}
