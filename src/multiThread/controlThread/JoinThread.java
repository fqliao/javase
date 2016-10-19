package multiThread.controlThread;

/**
 * @decription:
 * 功能：
 * 主线程数100个数，两个线程一起并发数100个数
 * 主线程数到20时，两个子线程立即开始并发数100，且当两个子线程数完之后，主线程在接着21开始数到100
 * 解决：join方法---引入别人自己阻塞
 * @version:1.0
 * @date: 2016年10月19日下午3:22:15
 * @author: lfq
 * 
 */
public class JoinThread{
	
	private static int i = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable r = (Runnable)()->{
			for (; i < 100; i++) 
			{
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
		};
		
		for (int i = 0; i < 100; i++) 
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i == 20)
			{
				Thread t1 = new Thread(r);
				Thread t2 = new Thread(r);
				t1.start();
				t2.start();
				t1.join();
				t2.join();
			}
		}

	}


}
