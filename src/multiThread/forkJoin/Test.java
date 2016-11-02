package multiThread.forkJoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @decription:Fork-Join框架测试
 * @version:1.0
 * @date: 2016年11月2日下午8:15:02
 * @author: lfq
 * 
 */
public class Test {

	public static void main(String[] args) {
		final int SIZE  = 10000000;
		double[] nums = new double[SIZE];
		for (int i = 0; i < SIZE; i++) 
		{
			nums[i] = Math.random();
		}
		
		//使用Fork-Join框架
		long start = System.currentTimeMillis();
		Counter counter = new Counter(nums,0,nums.length,new Filter()
		{
			@Override
			public boolean accept(double t) {
					return t > 0.5;
			}
			
		});
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(counter);
		System.out.println(counter.join());
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		//不使用Fork-Join框架 速度还快些？
//		long start = System.currentTimeMillis();
//		int count = 0;
//		for (int i = 0; i < nums.length; i++) 
//		{
//			if(nums[i] > 0.5)
//				count++;
//		}
//		System.out.println(count);
//		long end = System.currentTimeMillis();
//		System.out.println(end-start);
	}

}
