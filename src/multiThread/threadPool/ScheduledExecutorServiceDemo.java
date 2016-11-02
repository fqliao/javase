package multiThread.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		ScheduledFuture<?> task1 = pool.scheduleAtFixedRate(thread1, 0,1, TimeUnit.SECONDS);
		Future<Integer> task2 = pool.submit(thread2);
		System.out.println("任务2："+task2.get());
//		pool.shutdown();//关闭就不能周期性执行
		System.out.println(((ThreadPoolExecutor)pool).getLargestPoolSize());

	}

}
