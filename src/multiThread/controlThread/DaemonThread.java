package multiThread.controlThread;

/**
 * @decription:创建后台线程，setDaemon(true)
 * 后台线程随着前台线程的死亡而死亡，该程序中后台线程运行不到999就死亡了，因为前台线程main线程很快就死亡了
 * @version:1.0
 * @date: 2016年10月19日下午4:49:11
 * @author: lfq
 * 
 */
public class DaemonThread {

	public static void main(String[] args) {
		
		Runnable r = (Runnable)()->{
			for (int i = 0; i < 1000; i++)
			{
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
		};
		
		Thread t = new Thread(r);
		//设置为后台线程
		t.setDaemon(true);
		t.start();
		for (int i = 0; i < 10; i++) 
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		
	}

}
