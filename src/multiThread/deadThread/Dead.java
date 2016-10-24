package multiThread.deadThread;

/**
 * @decription:死锁，两个同步监视器
 * @version:1.0
 * @date: 2016年10月24日下午5:16:33
 * @author: lfq
 * 
 */
public class Dead implements Runnable {
	private boolean flag;

	public Dead(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run()
	{
		while (true) 
		{
			if (flag) 
			{
				synchronized (Lock.locka)//拿着锁locka
				{
					System.out.println("if locka");
					synchronized (Lock.lockb) //在锁池中等待锁lockb
					{
						System.out.println("if lockb");
					}
				}
			}
			else 
			{
				synchronized (Lock.lockb)//拿着锁lockb
				{
					System.out.println("else lockb");
					synchronized (Lock.locka) //等待锁locka
					{
						System.out.println("else locka");
					}
				}
			}
		}
	}
}