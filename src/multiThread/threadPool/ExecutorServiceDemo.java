package multiThread.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		Future<?> task1 = pool.submit(thread1);
		Future<Integer> task2 = pool.submit(thread2);
		System.out.println("任务2："+task2.get());
		pool.shutdown();
		System.out.println(((ThreadPoolExecutor)pool).getLargestPoolSize());

	}

}
