package multiThread.threadPool;

import java.util.concurrent.Callable;

public class Thread1 implements Callable<Integer>{

	@Override
	public Integer call() {
		int sum = 0;
		for (int i = 0; i < 10; i++) 
		{
			sum += i;
		}
		return sum;
	}

}
