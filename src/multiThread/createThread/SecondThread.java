package multiThread.createThread;

/**
 * @decription:实现Runnable接口方式创建线程
 * @version:1.0
 * @date: 2016年10月18日下午4:24:58
 * @author: lfq
 * 
 */
public class SecondThread implements Runnable{
	
	private int i = 0;
	@Override
	public void run() {
		for (; i < 100; i++) 
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if( i == 20)
			{	
				//这种分别创建对象的方式与直接继承Thread类一样
//				new Thread(new SecondThread()).start();
//				new Thread(new SecondThread()).start();
				
				//这种创建一个对象，分别放到两个线程中去，就实现了并发执行同一个顺序执行流,共享数据
				//但是这样共享数据还有问题，不安全，原因在于没有同步！同步是多线程开发的关键点
				//可以看出实现Runnable接口，关键好处在使用处
				SecondThread st = new SecondThread();
				new Thread(st).start();
				new Thread(st).start();
				//让子线程启动后立即执行，让主线程睡1ms,用Thread.sleep控制线程的执行顺序
				Thread.sleep(1);
			}
		}
		
	}


}
