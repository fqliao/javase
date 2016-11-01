package multiThread.threadPool;

import java.util.concurrent.Callable;

public class Thread2 implements Callable<Integer>{

	@Override
	public Integer call() {
		int sum = 0;
		for (int i = 1; i < 101; i++)
		{
			sum += i;
		}
		return sum;
	}

}
