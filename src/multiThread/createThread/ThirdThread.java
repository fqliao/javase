package multiThread.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @decription:实现Callable接口创建线程
 * @version:1.0
 * @date: 2016年10月18日下午4:25:18
 * @author: lfq
 * 
 */
public class ThirdThread implements Callable<Integer>{
	
	private int i = 0;
	//Callable带泛型,里面也只有一个call接口
	//Callable接口和Runnable接口都声明为了函数式接口，可用Lambda表达式创建对象
	//call方法有返回值，Runnable接口的run方法是没有返回值的
	//可知Callable接口(java5新增的，放在并发包中)是Runnable接口的增强版，有泛型
	//call方法是run方法的增强版，有返回值且可用抛出异常
	@Override
	public Integer call() throws Exception {
		for(;i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		return i;
	}
	
	public static  void main(String[] args) throws InterruptedException, ExecutionException {
		
		ThirdThread tt = new ThirdThread();
		//用FutureTask包装下Callable对象，FutureTask实现了Runnable接口
		//注意开两个线程是将Callable包装两个FutureTask对象，然后分别用来创建Thread对象，即创建了两个线程
		FutureTask<Integer> ft1 = new FutureTask<>(tt);
		FutureTask<Integer> ft2 = new FutureTask<>(tt);
		
		for( int i = 0; i < 100; i++)
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
