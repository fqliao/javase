package multiThread.createThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;
public class LambdaCallableThread {

	private static int i = 0;
	public static void main(String[] args) throws Exception, ExecutionException {
		//使用Lambda表达式创建Callable<Integer>对象 Lambda表示式初始化函数式接口简单
		Callable<Integer> c = (Callable<Integer>)()-> {
			for(;i < 100; i++)
			{
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
			return i;
		};
		//FutureTask包装Callable
		FutureTask<Integer> ft1 = new FutureTask<>(c);
		FutureTask<Integer> ft2 = new FutureTask<>(c);
		
		for (int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i == 20)
			{
				new Thread(ft1).start();
				new Thread(ft2).start();
			}
		}
		System.out.println("子线程ft1的返回值："+ft1.get());
		System.out.println("子线程ft2的返回值："+ft2.get());
	}

}
