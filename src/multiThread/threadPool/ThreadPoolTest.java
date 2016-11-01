package multiThread.threadPool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @decription:测试线程池
 * @version:1.0
 * @date: 2016年10月31日下午7:23:30
 * @author: lfq
 * 
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		String directory = "G:\\kk";
		String keyword = "性别";
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
		Future<Integer> result = pool.submit(counter);
		
		try 
		{
			System.out.println(result.get()+" matching files");
		} 
		catch (InterruptedException | ExecutionException e) 
		{
			e.printStackTrace();
		}
		pool.shutdown();
		
		int largestPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
		System.out.println("largest pool size="+largestPoolSize);
		
		
	}
}
