package multiThread.controlThread;

public class PriorityThread {
	
	private static int i = 0;
	public static void main(String[] args) {
		
		Runnable r = (Runnable)()->{
			for (; i < 100; i++) 
			{
				Thread.yield();//本质控制并发得更均匀一些而已,让步一下，让其他线性多执行下
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
		};
		System.out.println("main的默认优先级："+Thread.currentThread().getPriority());
		for (int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i == 2)
			{
				Thread t = new Thread(r);
				t.start();
				t.setPriority(Thread.MAX_PRIORITY);
			}
		}
		

	}

}
