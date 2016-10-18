package multiThread.createThread;

public class LambdaRunnableThread {
	
	private static int i = 0;
	
	public static void main(String[] args) {
		//Lambda表达式创建Runnable对象
		Runnable r = (Runnable)()->{
			for(;i < 100; i++)
			{
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
		};
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i == 20)
			{
				new Thread(r).start();
				new Thread(r).start();
			}
		}

	}

}
