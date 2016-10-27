package multiThread.communication.secondWay;


/**
 * @decription:测试线程通信
 * @version:1.0
 * @date: 2016年10月27日上午11:31:16
 * @author: lfq
 * 
 */
public class Client {

	public static void main(String[] args) {
		Account account = new Account("0101");
		DepositThread depositThread = new DepositThread(account, 10);
		DrawThread drawThread = new DrawThread(account, 10);
		
		new Thread(drawThread).start();
		new Thread(depositThread).start();
//		new Thread(depositThread).start();//存钱后，没有取钱的，就会阻塞等待，这不是死锁
//		new Thread(depositThread).start();
		
	}

}
